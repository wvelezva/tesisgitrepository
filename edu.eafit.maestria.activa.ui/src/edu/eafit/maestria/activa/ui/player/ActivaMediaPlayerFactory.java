package edu.eafit.maestria.activa.ui.player;

import java.util.List;

import uk.co.caprica.vlcj.logger.Logger;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;

public class ActivaMediaPlayerFactory extends MediaPlayerFactory {

	public ActivaMediaPlayerFactory(List<String> vlcArgs) {
		super(vlcArgs);
	}

	/**
	   * Create a new embedded media player.
	   * 
	   * @param fullScreenStrategy full screen implementation, may be <code>null</code>
	   * @return media player instance
	   */
	  public EmbeddedMediaPlayer newEmbeddedMediaPlayer(FullScreenStrategy fullScreenStrategy) {
	    Logger.debug("newEmbeddedMediaPlayer(fullScreenStrategy={})", fullScreenStrategy);
	    return new ActivaEmbeddedMediaPlayer(libvlc, instance, fullScreenStrategy);
	  }
}
