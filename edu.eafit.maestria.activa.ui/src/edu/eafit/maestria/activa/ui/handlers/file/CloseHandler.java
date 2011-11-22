package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class CloseHandler extends AbstractHandler implements IHandler {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), CloseHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Boolean saved = Boolean.FALSE;
		IHandlerService handlerService = (IHandlerService) HandlerUtil.getActiveWorkbenchWindow(event).getService(IHandlerService.class); 
		try {
			saved = (Boolean) handlerService.executeCommand(SaveDialogHandler.commandId, null);
		} catch (Exception e) {
			logger.logFatal(e);
			HandlerUtil.getActiveWorkbenchWindow(event).close();
		}
		
		if (saved) {
			ActivaPlayer.getInstance().disable();
			UIActivator.setProject(null);
		}
		return null;
	}

}
