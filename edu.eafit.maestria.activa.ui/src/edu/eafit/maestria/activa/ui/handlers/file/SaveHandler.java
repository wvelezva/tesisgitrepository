package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SaveHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SaveHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IProjectServices projectServices = (IProjectServices) Container.getInstance().getComponent(IProjectServices.class);
		projectServices.saveProject(UIActivator.getProject());
		return null;
	}

}
