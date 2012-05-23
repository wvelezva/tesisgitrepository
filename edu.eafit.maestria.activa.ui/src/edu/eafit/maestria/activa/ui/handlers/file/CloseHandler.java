package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class CloseHandler extends AbstractHandler implements IHandler {

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
		
		if (saved) {
			ActivaPlayer.getInstance().disable();
			Container.setProject(null);
		} else {
			logger.fatal(Messages.COMMAND_FILE_SAVE_ERROR);
			PlatformUI.getWorkbench().close();
		}
		return null;
	}

}
