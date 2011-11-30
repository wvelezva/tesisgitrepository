package edu.eafit.maestria.activa.ui.player.handlers;

import java.awt.Color;
import java.lang.reflect.Field;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SetColorHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SetColorHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String name = event.getParameter("activa.ui.param.color");
		
		try {
			Field field = Color.class.getField(name);
			Color color = (Color)field.get(null);
			ActivaPlayer.getInstance().getOverlay().setCurrentColor(color);
		} catch (Exception e) {
			logger.logError(e);
			ActivaPlayer.getInstance().getOverlay().setCurrentColor(Color.red);
		}
		
		return null;
	}

}
