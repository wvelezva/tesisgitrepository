package edu.eafit.maestria.activa.ui.handlers.file;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.services.IEntityServices;
import edu.eafit.maestria.activa.services.IProjectServices;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.Player;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SaveHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SaveHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Container.getProject() != null) {
			IProjectServices projectServices = (IProjectServices) Container.get(IProjectServices.class);
			projectServices.saveProject(Container.getProject());
		}
		
		return null;
	}

}
