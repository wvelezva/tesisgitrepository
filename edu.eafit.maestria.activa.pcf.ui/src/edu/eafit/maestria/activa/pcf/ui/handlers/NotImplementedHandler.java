package edu.eafit.maestria.activa.pcf.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.pcf.ui.PCFUIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class NotImplementedHandler extends AbstractHandler implements IHandler {

	private static final LogUtil logger = LogUtil.getInstance(PCFUIActivator.getDefault().getBundle().getSymbolicName());
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		logger.info("Not implemented");
		return null;
	}

}
