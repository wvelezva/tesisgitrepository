package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.services.IProjectServices;

public class SaveHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Container.getProject() != null) {
			IProjectServices projectServices = (IProjectServices) Container.get(IProjectServices.class);
			projectServices.saveProject(Container.getProject());
		}
		
		return null;
	}

}
