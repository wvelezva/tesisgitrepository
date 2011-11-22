package edu.eafit.maestria.activa.ui.player;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;

import uk.co.caprica.vlcj.player.AudioTrackInfo;
import uk.co.caprica.vlcj.player.TrackInfo;
import uk.co.caprica.vlcj.player.VideoTrackInfo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ActivaPlayer extends BaseVlcj {
	
	private static LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), ActivaPlayer.class);
	
	private ActivaMediaPlayerFactory factory;
	private EmbeddedMediaPlayer player;
	private PlayerControlsPanel controlsPanel;
	private Video video;
	private static ActivaPlayer vlcjPlayer;
	
	private ActivaPlayer(){
	}
	
	public static ActivaPlayer getInstance() {
		if (vlcjPlayer == null)
			vlcjPlayer = new ActivaPlayer();
		
		return vlcjPlayer;
	}
	
	CanvasVideoSurface currentVideoSurface ;
	public void createUI(Composite parent){
		if (player == null) {
//			
			/*VLC Player*/
			Composite videoComposite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE );
			videoComposite.setLayoutData(new RowData(600,400));
			videoComposite.setVisible(true);

			Canvas videoSurface = new Canvas();
			videoSurface.setBackground(Color.black);
			videoSurface.setSize(600, 400);
			
			Frame videoFrame = SWT_AWT.new_Frame(videoComposite);
			videoFrame.add(videoSurface);
			Overlay overlay = new Overlay(videoFrame);

			ActivaMouseAdapter activaMouseAdapter = new ActivaMouseAdapter(overlay);
			ActivaMouseMotionAdapter activaMouseMotionAdapter = new ActivaMouseMotionAdapter(overlay);
			videoSurface.addMouseListener(activaMouseAdapter);
			videoSurface.addMouseMotionListener(activaMouseMotionAdapter);
			
			vlcArgs.add("--width=" + 600);
		    vlcArgs.add("--height=" + 400);
		    factory = new ActivaMediaPlayerFactory(vlcArgs);
			player = factory.newEmbeddedMediaPlayer();
			currentVideoSurface = factory.newVideoSurface(videoSurface);
			player.setVideoSurface(currentVideoSurface);
			player.setPlaySubItems(true);
			player.setEnableKeyInputHandling(false);
		    player.setEnableMouseInputHandling(false);
		    player.setOverlay(overlay);
		    controlsPanel = new PlayerControlsPanel(parent, player);
		   
		}
	}
	
		
	/**
	 * Release the media player component and the associated native media player
	 * resources.
	 */
	public void release() {
		onBeforeRelease();
		if (player != null) {
			if (player.isPlaying())
				player.stop();
			player.release();
			player = null;
		}
		if (factory != null) {
			factory.release();
			factory = null;
		}
		onAfterRelease();
	}
	
	private void onAfterRelease() {
	}

	private void onBeforeRelease() {
	}

	public EmbeddedMediaPlayer getPlayer(){
		if (player == null) {
			throw new RuntimeException("The player hasn't been initialized. You have to call VlcjPlayer.createUI(composite) first");
		}
		return player;
	}

	/**
	 * when is a new project the first snece is saved
	 * @param video
	 * @return
	 */
	public boolean prepareNewMedia(Video video) {
		prepareMedia(video);
		//corriendo el ejemplo mediainfotest se obtiene una salida que se puede parsear y obtener algunos datos
		//este es un ejemplo de la salida
		//mediaPlayer.getTrackInfo()
		//Track Information before end: [VideoTrackInfo[codec=1986490477,codecName=vgpm,id=0,profile=-1,level=-1][width=0,height=0], AudioTrackInfo[codec=1634168941,codecName=agpm,id=1,profile=-1,level=-1][channels=0,rate=0], VideoTrackInfo[codec=1986490477,codecName=vgpm,id=2,profile=-1,level=-1][width=0,height=0]]
		//se deberia de lanzar un hilo para esperar esta salida por que no siempre esta disponible inmediatamente

		List<TrackInfo> trackInfos = player.getTrackInfo();
		for (TrackInfo trackInfo : trackInfos) {
			if (trackInfo instanceof VideoTrackInfo) { 
				VideoTrackInfo vti = (VideoTrackInfo) trackInfo;
				video.setVideoCodec(vti.codecName());
				video.setWidth(vti.width());
				video.setHeight(vti.height());
			}
			else if (trackInfo instanceof AudioTrackInfo) {
				AudioTrackInfo ati = (AudioTrackInfo) trackInfo;
				video.setAudioCodec(ati.codecName());
				//video.setAudioInfo(ati.);
			}
		}

		video.setLength(player.getLength());
		video.setFps(player.getFps());
		Scene scene = video.getScenes().get(0);
		scene.setEnd(player.getLength());
		
		saveSnapshot(scene);
		
		return true;
	}

	public boolean prepareMedia(Video video) {
		this.video = video;
//		player.prepareMedia(video.getVideo().getAbsolutePath());
//		player.parseMedia();
//		player.play();
		player.playMedia(video.getVideo().getAbsolutePath());
		try {
		    // Half a second probably gets an iframe
		    Thread.sleep(500);  
	    } 
	    catch(InterruptedException e) {
		    // Don't care if unblocked early
	    }
		player.pause();
		enable();
        return true;
	}
	
	private void saveSnapshot(long scene) {
		if (player == null || video == null || video.getSnapshotDirectory() == null) {
			logger.logWarning("player not initialized");
			return;
		}
		
		try {
			java.text.DecimalFormat snapshotNumberFormat = new java.text.DecimalFormat(Constants.File.SNAPSHOT_FILE_NAME_FORMAT);
			String id = snapshotNumberFormat.format(scene);
			player.saveSnapshot(new File(video.getSnapshotDirectory(), id + Constants.File.SNAPSHOT_FILE_EXTENSION));
			player.saveSnapshot(new File(video.getSnapshotDirectory(), Constants.File.THUMBNAIL + id + Constants.File.SNAPSHOT_FILE_EXTENSION), 100, 0);
		} catch (Exception e) {
			logger.logWarning(Messages.SAVE_SNAPSHOT_ERROR, e);
		}
	}
	
	private void saveSnapshot(Scene scene) {
		if (player == null || video == null || video.getSnapshotDirectory() == null) {
			logger.logWarning("player not initialized");
			return;
		}
		
//		En el ejemplo snapshottest hacen esto para tomar el snapshot, van a una posicion y duermen
//		mediaPlayer.startMedia(args[0]);
//	    mediaPlayer.setPosition(0.25f);
//	    Thread.sleep(1000)
//		tambien muestran un bufferedimage demas que se puede usar para la linea de tiempo
	    
		player.setPosition(0.25f);
//	    mediaPlayer.setPosition(0.25f);
		
		try {
			java.text.DecimalFormat snapshotNumberFormat = new java.text.DecimalFormat(Constants.File.SNAPSHOT_FILE_NAME_FORMAT);
			String id = snapshotNumberFormat.format(scene.getId());
			
			File snapshot = new File(video.getSnapshotDirectory(), id + Constants.File.SNAPSHOT_FILE_EXTENSION);
			if (player.saveSnapshot(snapshot))
				scene.setScene(snapshot);
				
			File thumbnail = new File(video.getSnapshotDirectory(), Constants.File.THUMBNAIL + id + Constants.File.SNAPSHOT_FILE_EXTENSION);
			if (player.saveSnapshot(thumbnail, 100, 50)) {
				scene.setThumbnail(thumbnail);
			}
		} catch (Exception e) {
			logger.logWarning(Messages.SAVE_SNAPSHOT_ERROR, e);
		}
	}
	
	public void enable(){
		player.enableOverlay(true);
		controlsPanel.setEnabled(true);
	}
	
	public void disable(){
		video = null;
		player.stop();
		player.enableOverlay(false);
		controlsPanel.setEnabled(false);
	}
	
	
		  
	public void pause() {
		controlsPanel.pause();
	}
	
	
//de estas hay que buscar que se puede configurar, yo creo que muchas ya estan en forma de sets
//		player.addMediaOptions(paramArrayOfString);
//		player.setStandardMediaOptions(options);
//		System.out.println("aspect ratio: " + player.getAspectRatio());
//		System.out.println("frames por segundo:" + player.getFps());
//		System.out.println("length in ms:" + player.getLength());
//		System.out.println("movie position (en que medida?):" + player.getPosition());
//		System.out.println("scaling factor:" + player.getScale());
//		System.out.println("current time:" + player.getTime());
//				
//		System.out.println("snapshot" + player.getSnapshot());
//		//las medidas del snapshot thumbnail dependen del aspect ratio del video
//		//pueder p.e.: la mitad de la altura y la mitad del ancho
//		System.out.println("snapshot con tamano:" + player.getSnapshot(100, 100));
//		System.out.println("guarda el snapshot:" + player.saveSnapshot());
//		System.out.println("guarda el snapshot con tamano:" + player.saveSnapshot(100, 100));
//		System.out.println("guarda el snapshot en file:" + player.saveSnapshot(new File("")));
//		System.out.println("guarda el snapshot en file con un tamano:" + player.saveSnapshot(new File(""), 100, 100));
//		System.out.println("is mute:" + player.isMute());
//		System.out.println("is playable:" + player.isPlayable());
//		System.out.println("is playing:" + player.isPlaying());
//		System.out.println("is seekable:" + player.isSeekable());
//		player.skipPosition(14f); //salta a la posicion actual + 14 en no se que unidades
//		player.skip(199); //salta al tiempo actual + 199 ms
//		player.setPosition(14f); //salta a la posicion 14
//		player.setTime(199); //salta al tiempo 199
//		System.out.println("dimension :" +player.getVideoDimension());
//		player.nextFrame();
//		player.setOverlay(Window.get);
}
