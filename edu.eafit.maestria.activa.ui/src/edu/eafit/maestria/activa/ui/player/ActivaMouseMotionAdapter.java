package edu.eafit.maestria.activa.ui.player;

import java.awt.event.MouseMotionAdapter;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.handlers.LoadEntityHandler;
import edu.eafit.maestria.activa.utilities.LogUtil;

public abstract class ActivaMouseMotionAdapter extends MouseMotionAdapter {
	
	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), ActivaMouseMotionAdapter.class);
	
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
