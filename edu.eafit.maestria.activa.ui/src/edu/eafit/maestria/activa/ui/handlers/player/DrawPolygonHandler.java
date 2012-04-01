package edu.eafit.maestria.activa.ui.handlers.player;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.DrawPolygonMouseAdapter;
import edu.eafit.maestria.activa.ui.player.DrawPolygonMouseMotionAdapter;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class DrawPolygonHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), DrawPolygonHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ActivaPlayer.getInstance().addActivaMouseListener(new DrawPolygonMouseAdapter());
		ActivaPlayer.getInstance().addActivaMouseMotionListener(new DrawPolygonMouseMotionAdapter());
		
		return null;
	}

}
