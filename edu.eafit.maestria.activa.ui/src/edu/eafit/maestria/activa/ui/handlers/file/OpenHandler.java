package edu.eafit.maestria.activa.ui.handlers.file;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class OpenHandler extends AbstractHandler implements IHandler {

	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Boolean saved = Boolean.FALSE;
		IHandlerService handlerService = (IHandlerService) HandlerUtil.getActiveWorkbenchWindow(event).getService(IHandlerService.class); 
		try {
			saved = (Boolean) handlerService.executeCommand(SaveDialogHandler.commandId, null);
		} catch (Exception e) {
			logger.fatal(e, Messages.COMMAND_FILE_SAVE_ERROR);
			PlatformUI.getWorkbench().close();
		}
		
		if (saved.booleanValue()) {
			Shell shell = HandlerUtil.getActiveShell(event);
			DirectoryDialog dirDialog = new DirectoryDialog(shell);
			dirDialog.setText(Messages.COMMAND_FILE_OPEN_MSG_DIALOG);
			IPreferenceStore store = UIActivator.getDefault().getPreferenceStore();
			dirDialog.setFilterPath(store.getString(Constants.Preferences.WORKSPACE));
			String dirName = dirDialog.open();
			
			if (StringUtils.isNotBlank(dirName)) {
				IProjectServices projectServices = (IProjectServices) Container.get(IProjectServices.class);
				Project project = projectServices.loadProject(dirName);
				Container.setProject(project);
				ActivaPlayer.getInstance().prepareMedia(project.getVideo());
			}
		} else {
			logger.fatal(Messages.COMMAND_FILE_SAVE_ERROR);
			PlatformUI.getWorkbench().close();
		}
		
		return null;
	}
	
	

}
