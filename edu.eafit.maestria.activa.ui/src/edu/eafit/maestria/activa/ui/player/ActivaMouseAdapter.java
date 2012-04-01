package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseAdapter;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.handlers.player.LoadEntityHandler;
import edu.eafit.maestria.activa.utilities.LogUtil;

public abstract class ActivaMouseAdapter extends MouseAdapter {
	
	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), ActivaMouseAdapter.class);
	
	public abstract void setOverlay(Overlay overlay);
	
	protected void loadEntity(){
		try {
			IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
			handlerService.executeCommand(LoadEntityHandler.commandId, null);
		} catch (Exception ex) {
			logger.logFatal(ex);
			PlatformUI.getWorkbench().close();
		}
	}

}
