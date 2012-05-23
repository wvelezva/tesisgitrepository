package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class SaveDialogHandler extends AbstractHandler implements IHandler {

	public static final String commandId = "activa.ui.command.file.saveDialog";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project project = Container.getProject();
		if (project != null && project.isModified()) {
			MessageDialog messageDialog = new MessageDialog(HandlerUtil.getActiveShell(event), 
					Messages.COMMAND_FILE_SAVE_PROJECT_TITLE, null, 
					Messages.COMMAND_FILE_SAVE_PROJECT_MSG, 
					MessageDialog.QUESTION, 
					new String[] { Messages.COMMAND_FILE_BUTTON_DONT_SAVE, Messages.COMMAND_FILE_BUTTON_CANCEL, Messages.COMMAND_FILE_BUTTON_SAVE }, 0);
			int returnCode = messageDialog.open();
			if  (returnCode == 2) {
				IProjectServices projectServices = (IProjectServices) Container.get(IProjectServices.class);
				projectServices.saveProject(project);
			} else if (returnCode == 1) {
				return Boolean.FALSE;
			}
		}
		
		return Boolean.TRUE;
	}

}
