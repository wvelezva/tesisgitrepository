package edu.eafit.maestria.activa.ui.handlers.player;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.DrawRectangleMouseAdapter;
import edu.eafit.maestria.activa.ui.player.DrawRectangleMouseMotionAdapter;

public class DrawRectangleHandler extends AbstractHandler implements IHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ActivaPlayer.getInstance().addActivaMouseListener(new DrawRectangleMouseAdapter());
		ActivaPlayer.getInstance().addActivaMouseMotionListener(new DrawRectangleMouseMotionAdapter());
		
		return null;
	}

}
