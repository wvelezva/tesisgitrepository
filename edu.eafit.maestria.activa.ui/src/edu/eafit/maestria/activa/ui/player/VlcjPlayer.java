package edu.eafit.maestria.activa.ui.player;

import java.awt.Canvas;
import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

public class VlcjPlayer extends BaseVlcj {
	
	private static VlcjPlayer vlcjPlayer;
	
	private MediaPlayerFactory mediaPlayerFactory;
	private EmbeddedMediaPlayer embeddedMediaPlayer;
	
	private VlcjPlayer(){
	}
	
	public static void createUI(Composite parent){
		if (vlcjPlayer == null) {
			vlcjPlayer = new VlcjPlayer();
		
			/*VLC Player*/
			Composite videoComposite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
			java.awt.Frame videoFrame = SWT_AWT.new_Frame(videoComposite);
			
			Canvas playerCanvas = new Canvas();
			playerCanvas.setBackground(Color.black);
			videoFrame.add(playerCanvas);
			//videoComposite.setBounds(parent.getBounds());
			RowData rd = (RowData) parent.getLayoutData();
			videoComposite.setBounds(5,5, rd.width - 20, rd.height - 50);
			//videoComposite.setSize(parent.getSize());
			videoComposite.setVisible(true);
			vlcjPlayer.setMediaPlayerFactory(new MediaPlayerFactory(vlcArgs));
			vlcjPlayer.setEmbeddedMediaPlayer(vlcjPlayer.getMediaPlayerFactory().newEmbeddedMediaPlayer(null));
			vlcjPlayer.getEmbeddedMediaPlayer().setVideoSurface(vlcjPlayer.getMediaPlayerFactory().newVideoSurface(playerCanvas));
			
		}
	}
	
	public static VlcjPlayer getInstance(){
		if (vlcjPlayer == null) {
			throw new RuntimeException("The player hasn't been initialized. You have to call createUI first");
		}
		
		return vlcjPlayer;
	}
	

	public MediaPlayerFactory getMediaPlayerFactory() {
		return mediaPlayerFactory;
	}

	public EmbeddedMediaPlayer getEmbeddedMediaPlayer() {
		return embeddedMediaPlayer;
	}

	public void setMediaPlayerFactory(MediaPlayerFactory mediaPlayerFactory) {
		this.mediaPlayerFactory = mediaPlayerFactory;
	}

	public void setEmbeddedMediaPlayer(EmbeddedMediaPlayer embeddedMediaPlayer) {
		this.embeddedMediaPlayer = embeddedMediaPlayer;
	}
	
	
}
