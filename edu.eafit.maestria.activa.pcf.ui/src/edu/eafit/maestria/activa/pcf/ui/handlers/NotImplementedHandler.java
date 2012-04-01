package edu.eafit.maestria.activa.pcf.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.pcf.ui.PCFUIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class NotImplementedHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(PCFUIActivator.getDefault().getBundle().getSymbolicName(), NotImplementedHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		logger.logInfo("Not implemented");
		return null;
	}

}
