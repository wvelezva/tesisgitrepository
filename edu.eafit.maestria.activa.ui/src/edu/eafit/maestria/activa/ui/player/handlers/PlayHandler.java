package edu.eafit.maestria.activa.ui.player.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

import edu.eafit.maestria.activa.ui.player.VlcjPlayer;


public class PlayHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		VlcjPlayer.getInstance().getEmbeddedMediaPlayer().playMedia("/Users/wvelezva/Movies/How.To.Lose.Friends.&.Alienate.People[2008]DvDrip-aXXo/How.To.Lose.Friends.&.Alienate.People[2008]DvDrip-aXXo.avi");
		VlcjPlayer.getInstance().getEmbeddedMediaPlayer().enableOverlay(true);
		
		return null;
	}

}
