package edu.eafit.maestria.activa.pcf.ui.handlers.generate;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.pcf.ui.PCFUIActivator;
import edu.eafit.maestria.activa.services.IInteroperableFormatServices;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PCFHandler extends AbstractHandler implements IHandler {

	LogUtil logger = LogUtil.getInstance(PCFUIActivator.getDefault().getBundle().getSymbolicName(), PCFHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Boolean saved = Boolean.FALSE;
		IHandlerService handlerService = (IHandlerService) HandlerUtil.getActiveWorkbenchWindow(event).getService(IHandlerService.class); 
		try {
			saved = (Boolean) handlerService.executeCommand("activa.ui.command.file.saveDialog", null);
		} catch (Exception e) {
			logger.logFatal(e);
			HandlerUtil.getActiveWorkbenchWindow(event).close();
		}
		
		if (saved) {
			IInteroperableFormatServices pcfServices = (IInteroperableFormatServices) Container.get(IInteroperableFormatServices.class);
			pcfServices.export(Container.getProject());
		}
		return null;
	}

}
