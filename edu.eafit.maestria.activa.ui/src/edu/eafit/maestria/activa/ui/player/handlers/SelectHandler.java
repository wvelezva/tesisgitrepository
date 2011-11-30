package edu.eafit.maestria.activa.ui.player.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.player.ActivaPlayer;
import edu.eafit.maestria.activa.ui.player.SelectMouseAdapter;
import edu.eafit.maestria.activa.ui.player.SelectMouseMotionAdapter;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class SelectHandler extends AbstractHandler implements IHandler {

	private final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), SelectHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ActivaPlayer.getInstance().addActivaMouseListener(new SelectMouseAdapter());
		ActivaPlayer.getInstance().addActivaMouseMotionListener(new SelectMouseMotionAdapter());
		
		return null;
	}

}
