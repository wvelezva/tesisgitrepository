package edu.eafit.maestria.activa.ui.handlers.player;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.MoveMouseAdapter;
import edu.eafit.maestria.activa.ui.player.MoveMouseMotionAdapter;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class MoveHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), MoveHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ActivaPlayer.getInstance().addActivaMouseListener(new MoveMouseAdapter());
		ActivaPlayer.getInstance().addActivaMouseMotionListener(new MoveMouseMotionAdapter());
		
		return null;
	}

}
