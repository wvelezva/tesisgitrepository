package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class NewHandler extends AbstractHandler implements IHandler {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), NewHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Boolean saved = null;
		IHandlerService handlerService = (IHandlerService) HandlerUtil.getActiveWorkbenchWindow(event).getService(IHandlerService.class); 
		try {
			saved = (Boolean) handlerService.executeCommand(SaveDialogHandler.commandId, null);
		} catch (Exception e) {
			logger.logFatal(e);
			HandlerUtil.getActiveWorkbenchWindow(event).close();
		}
		
		if (saved.booleanValue()) {
			NewWizard wizard = new NewWizard(event);
			WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
			dialog.open();
		}
		return null;
	}

}
