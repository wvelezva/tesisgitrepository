package edu.eafit.maestria.activa.ui.player;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import uk.co.caprica.vlcj.player.AudioTrackInfo;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.TrackInfo;
import uk.co.caprica.vlcj.player.VideoTrackInfo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ActivaPlayer extends BaseVlcj {
	
	private static final int WIDTH = 810;
	private static final int HEIGHT = 530;

	private static LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), ActivaPlayer.class);
	
	private ScheduledExecutorService executorService; 
	
	//private ActivaMediaPlayerFactory factory;
	private MediaPlayerFactory factory;
	private EmbeddedMediaPlayer player;
	private PlayerControlsPanel controlsPanel;
	private Video video;
	private Frame videoFrame; 
	private Canvas videoSurface;
	
	private static ActivaPlayer vlcjPlayer;
	
	private ActivaPlayer(){
	}
	
	public static ActivaPlayer getInstance() {
		if (vlcjPlayer == null)
			vlcjPlayer = new ActivaPlayer();
		
		return vlcjPlayer;
	}
	
	public void createUI(Composite parent){
		if (player == null) {
//			
			/*VLC Player*/
			Composite videoComposite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE );
			videoComposite.setLayoutData(new RowData(WIDTH,HEIGHT));
			videoComposite.setVisible(true);

			videoSurface = new Canvas();
			videoSurface.setBackground(Color.black);
			videoSurface.setSize(WIDTH, HEIGHT);
			
			videoFrame = SWT_AWT.new_Frame(videoComposite);
			videoFrame.add(videoSurface);
			vlcArgs.add("--width=" + WIDTH);
		    vlcArgs.add("--height=" + HEIGHT);
		    factory = new ActivaMediaPlayerFactory(vlcArgs);
			player = factory.newEmbeddedMediaPlayer();
			player.setVideoSurface(factory.newVideoSurface(videoSurface));
			player.setPlaySubItems(true);
			player.setEnableKeyInputHandling(false);
		    player.setEnableMouseInputHandling(false);
		    
		    controlsPanel = new PlayerControlsPanel(parent, player);
		   
		}
	}

	private void setOverlay() {
		videoSurface.addMouseListener(new DrawRectangleMouseAdapter());
		videoSurface.addMouseMotionListener(new DrawRectangleMouseMotionAdapter());
		player.setOverlay( new Overlay(videoFrame));
	    player.enableOverlay(true);
	    
	    long period = 0;
		if (player.getFps() > 0) {
			double floor = Math.floor(1000/player.getFps()/1.5);
			period = Double.valueOf(floor).longValue();
		} else {
			 period = 28; //(1000/24)/1.5=28 one second in milliseconds/number of frames by default
		}
		
		executorService = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture sf = executorService.scheduleAtFixedRate(new UpdateOverlay(), 0L, period, TimeUnit.MILLISECONDS);
		
	}
	
	public void addActivaMouseListener(ActivaMouseAdapter mouseListener) {
		for (MouseListener ml : videoSurface.getMouseListeners()) {
			videoSurface.removeMouseListener(ml);
		}
		mouseListener.setOverlay((Overlay)player.getOverlay());
		videoSurface.addMouseListener(mouseListener);
	}
	
	public void addActivaMouseMotionListener(ActivaMouseMotionAdapter mouseMotionListener) {
		for (MouseMotionListener mml : videoSurface.getMouseMotionListeners()) {
			videoSurface.removeMouseMotionListener(mml);
		}
		mouseMotionListener.setOverlay((Overlay)player.getOverlay());
		videoSurface.addMouseMotionListener(mouseMotionListener);
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

	public Overlay getOverlay(){
		if (player == null) {
			throw new RuntimeException("The player hasn't been initialized. You have to call VlcjPlayer.createUI(composite) first");
		}
		return (Overlay)player.getOverlay();
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
		
		setOverlay();
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
		setOverlay();
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
		executorService.shutdownNow();
		player.stop();
		player.enableOverlay(false);
		player.setOverlay(null);
		controlsPanel.setEnabled(false);
	}
		  
	public void pause() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				controlsPanel.pause();
			}
		});
	}
	
	private final class UpdateOverlay implements Runnable {

		@Override
		public void run() {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
//					if (player.isPlaying()) {
					Overlay overlay = (Overlay)player.getOverlay();
					if (overlay !=null) {
						double currentFrame = Math.floor((player.getFps()/1000)*player.getTime());
						int frame = Double.valueOf(currentFrame).intValue();
						overlay.setCurrentFrame(frame);
					}
//					}
				}
			});
		}
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
