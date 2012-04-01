package edu.eafit.maestria.activa.ui.player;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import uk.co.caprica.vlcj.player.AudioTrackInfo;
import uk.co.caprica.vlcj.player.MediaDetails;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.TrackInfo;
import uk.co.caprica.vlcj.player.VideoTrackInfo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.Scene;
import edu.eafit.maestria.activa.model.Video;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ActivaPlayer extends BaseVlcj {
	
	private static LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), ActivaPlayer.class);
	
	private ScheduledExecutorService executorService; 
	private DecimalFormat snapshotNumberFormat;
	
	//private ActivaMediaPlayerFactory factory;
	private MediaPlayerFactory factory;
	private EmbeddedMediaPlayer player;
	private PlayerControlsPanel controlsPanel;
	private Video video;
	private Frame videoFrame; 
	private Canvas videoSurface;
	private Player view;
	
	private boolean correctionsCalculated;
	private Dimension videoDimension;
	private int correctionX;
	private int correctionY;
	private int maxWidth;
	private int maxHeight;
	
	private static ActivaPlayer vlcjPlayer;
	
	private ActivaPlayer(){
		snapshotNumberFormat = new DecimalFormat(Constants.File.SNAPSHOT_FILE_NAME_FORMAT);
	}
	
	public static ActivaPlayer getInstance() {
		if (vlcjPlayer == null)
			vlcjPlayer = new ActivaPlayer();
		
		return vlcjPlayer;
	}
	
	public void createUI(Composite parent, Player view){
		if (player == null) {
//			
			/*VLC Player*/
			Composite videoComposite = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND | SWT.NO_REDRAW_RESIZE );
			videoComposite.setLayoutData(new RowData(Constants.Player.WIDTH,Constants.Player.HEIGHT));
			videoComposite.setVisible(true);

			videoSurface = new Canvas();
			videoSurface.setBackground(Color.black);
			videoSurface.setSize(Constants.Player.WIDTH, Constants.Player.HEIGHT);
			
			videoFrame = SWT_AWT.new_Frame(videoComposite);
			videoFrame.add(videoSurface);
			vlcArgs.add("--width=" + Constants.Player.WIDTH);
		    vlcArgs.add("--height=" + Constants.Player.HEIGHT);
		    factory = new ActivaMediaPlayerFactory(vlcArgs);
			player = factory.newEmbeddedMediaPlayer();
			player.setVideoSurface(factory.newVideoSurface(videoSurface));
			player.setPlaySubItems(true);
			player.setEnableKeyInputHandling(false);
		    player.setEnableMouseInputHandling(false);
		    
		    controlsPanel = new PlayerControlsPanel(parent, player);
		    this.view = view;
		}
	}

	private void setOverlay() {
		videoSurface.addMouseListener(new DrawRectangleMouseAdapter());
		videoSurface.addMouseMotionListener(new DrawRectangleMouseMotionAdapter());
		player.setOverlay(new Overlay(videoFrame));
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
	public boolean prepareNewMedia(final Video video) {
		this.video=video;
//		if (!player.startMedia(video.getVideo().getAbsolutePath())) {
//			logger.logError("The media doesn't start");
//			return false;
//		}
		player.prepareMedia(this.video.getVideo().getAbsolutePath());
		//player.parseMedia();
		
		
		MediaPlayerEventAdapter mediaPlayerEventAdapter = new MediaPlayerEventAdapter() {
				@Override
				public void playing(MediaPlayer mediaPlayer) {
					//TODO otro que hay que ensayar para sacar meta info del video
					MediaDetails mediaDetails = player.getMediaDetails();
					
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

					//System.out.println(player.getSnapshot());
					//System.out.println(player.getVideoSurfaceContents());
					//System.out.println(player.getVideoDimension());
					
					
					video.setLength(player.getLength());
					video.setFps(player.getFps());
					
					saveSnapshot(video.getScenes().get(0));
					player.stop();
					player.removeMediaPlayerEventListener(this);
				}
			};
		
		player.addMediaPlayerEventListener(mediaPlayerEventAdapter);
		
		player.play();
		
		//saveSnapshot(video.getScenes().get(0));
		//player.setTime(0);
//		player.pause();
		
		setOverlay();
		enable();
		correctionsCalculated = false;
		return true;
	}

	public boolean prepareMedia(Video video) {
		this.video = video;
		player.prepareMedia(video.getVideo().getAbsolutePath());
		
		setOverlay();
		enable();
		correctionsCalculated = false;
		return true;
	}
	
	public void saveSnapshot(long scene) {
		if (player == null || video == null || video.getSnapshotDirectory() == null) {
			logger.logWarning("player not initialized");
			return;
		}
		
		try {
			java.text.DecimalFormat snapshotNumberFormat = new java.text.DecimalFormat(Constants.File.SNAPSHOT_FILE_NAME_FORMAT);
			String id = snapshotNumberFormat.format(scene);
			player.saveSnapshot(new File(video.getSnapshotDirectory(), id + Constants.File.SNAPSHOT_FILE_EXTENSION));
			player.saveSnapshot(new File(video.getSnapshotDirectory(), id + Constants.File.THUMBNAIL + Constants.File.SNAPSHOT_FILE_EXTENSION), 100, 0);
		} catch (Exception e) {
			logger.logWarning(Messages.SAVE_SNAPSHOT_ERROR, e);
		}
	}
	
	public boolean saveSnapshot(Scene scene) {
		if (player == null || video == null || video.getSnapshotDirectory() == null) {
			logger.logWarning("player not initialized");
			return false;
		}
		
//		En el ejemplo snapshottest hacen esto para tomar el snapshot, van a una posicion y duermen
//		mediaPlayer.startMedia(args[0]);
//	    mediaPlayer.setPosition(0.25f);
//	    Thread.sleep(1000)
//		tambien muestran un bufferedimage demas que se puede usar para la linea de tiempo
	    
//		player.setPosition(0.25f);
//	    mediaPlayer.setPosition(0.25f);
		
		try {
			
			String id = snapshotNumberFormat.format(scene.getId());
			
			File snapshot = new File(video.getSnapshotDirectory(), id + Constants.File.SNAPSHOT_FILE_EXTENSION);
			if (player.saveSnapshot(snapshot)) {
				scene.setScene(snapshot);
					
				File thumbnail = new File(video.getSnapshotDirectory(), id + Constants.File.THUMBNAIL + Constants.File.SNAPSHOT_FILE_EXTENSION);
				if (player.saveSnapshot(thumbnail, Constants.Player.THUMBNAIL_WIDTH, 0)) {
					scene.setThumbnail(thumbnail);
					return true;
				}
			}
			
			
		} catch (Exception e) {
			logger.logWarning(Messages.SAVE_SNAPSHOT_ERROR, e);
		}
		return false;
	}
	
	public void enable(){
		player.enableOverlay(true);
		controlsPanel.setEnabled(true);
		view.enableProperties(true);
	}
	
	public void disable(){
		video = null;
		executorService.shutdownNow();
		player.stop();
		player.enableOverlay(false);
		player.setOverlay(null);
		controlsPanel.setEnabled(false);
		view.enableProperties(false);
	}
		  
	public void pause() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				controlsPanel.pause();
			}
		});
	}
	
	
	private int lastFrame=0;
	
	private final class UpdateOverlay implements Runnable {

		@Override
		public void run() {
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					Overlay overlay = (Overlay)player.getOverlay();
					if (overlay !=null && controlsPanel.getCurrentFrame() != null) {
						
						if (controlsPanel.isFrameByFrame()) {
							if (overlay.getAnimations() != null && !overlay.getAnimations().isEmpty()) {
								List<Animation> nextAnimations = video.getAnimationsByFrame(controlsPanel.getCurrentFrame().intValue());
								if (nextAnimations == null || nextAnimations.isEmpty())
									if (MessageDialog.openQuestion(view.getSite().getShell(), "Question", "Do you want to copy the shapes from the last frame?" + lastFrame + "-" + controlsPanel.getCurrentFrame().intValue()))
										video.copyAnimations(lastFrame, controlsPanel.getCurrentFrame().intValue());
							}
							
							overlay.setCurrentFrame(controlsPanel.getCurrentFrame().intValue());
							lastFrame = controlsPanel.getCurrentFrame().intValue();
							controlsPanel.resetFrameByFrame();
						} else {
							overlay.setCurrentFrame(controlsPanel.getCurrentFrame().intValue());
							lastFrame = controlsPanel.getCurrentFrame().intValue();
						}
					}
				}
			});
		}
	}
	
	public int getCurrentFrame(){
		if (controlsPanel != null && controlsPanel.getCurrentFrame() != null)
			return controlsPanel.getCurrentFrame().intValue();
		
		return -1;
	}
	
	public long getCurrentTime(){
		if (player != null)
			return player.getTime();
		
		return -1;
	}
	
//	public BufferedImage getSnapshot(){
//		if (player != null)
//			return player.getSnapshot();
//		
//		return null;
//	}
	
	public BufferedImage getTemplate(Rectangle rectangle, File outputfile) {
		Rectangle fixed = fix(rectangle);
		BufferedImage template = null;
		try {
			BufferedImage snapshot = player.getSnapshot();
			if (snapshot == null) {
				logger.logError("Snapshot not taken");
				return null;
			}
			template = snapshot.getSubimage(fixed.x, fixed.y, fixed.width, fixed.height);
			
			if (outputfile != null)
				ImageIO.write(template, "jpg", outputfile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return template;
	}

	public BufferedImage getTemplate(Rectangle rectangle){
		return getTemplate(rectangle, null);
	}
			
	private Rectangle fix(Rectangle rectangle) {
		return new Rectangle(adjustXToVideo(rectangle.x), 
				adjustYToVideo(rectangle.y), 
				adjustXToVideoNoCorrection(rectangle.width), 
				adjustYToVideoNoCorrection(rectangle.height));
	}
	
	private void calculateCorrections(){
		if (correctionsCalculated)
			return;
		
		correctionsCalculated = true;
		videoDimension= player.getVideoDimension();
		double aspectRatio = (double)videoDimension.width/videoDimension.height;
		
		maxWidth = Constants.Player.WIDTH;
		maxHeight = Constants.Player.HEIGHT;
		
		if (((double)Constants.Player.WIDTH / Constants.Player.HEIGHT) > aspectRatio)
			maxWidth = (int) Math.ceil(maxHeight * aspectRatio);
		else
			maxHeight = (int) Math.ceil(maxWidth / aspectRatio);
		
		correctionX = (Constants.Player.WIDTH - maxWidth)/2;
		correctionY = (Constants.Player.HEIGHT- maxHeight)/2;
	}
	
	public int adjustXToVideo(int x){
		calculateCorrections();
		return (int)(x - correctionX) * videoDimension.width/maxWidth;
	}
	
	public int adjustXToVideoNoCorrection(int x){
		calculateCorrections();
		return x * videoDimension.width/maxWidth;
	}

	public int adjustYToVideoNoCorrection(int y){
		calculateCorrections();
		return y * videoDimension.height/maxHeight;
	}
	
	public int adjustVideoToX(int x){
		calculateCorrections();
		return  (x * maxWidth/ videoDimension.width) + correctionX; 
	}
	
	public int adjustYToVideo(int y){
		calculateCorrections();
		return (int)(y - correctionY) * videoDimension.height/maxHeight;
	}

	public int adjustVideoToY(int y){
		calculateCorrections();
		return  (y * maxHeight/ videoDimension.height) + correctionY; 
	}
	
	
//de estas hay que buscar que se puede configurar, yo creo que muchas ya estan en forma de sets
//		player.addMediaOptions(paramArrayOfString);
//		player.setStandardMediaOptions(options);
//		System.out.println("aspect ratio: " + player.getAspectRatio());
//		System.out.println("scaling factor:" + player.getScale());
//				
//		System.out.println("snapshot" + player.getSnapshot());
//		//las medidas del snapshot thumbnail dependen del aspect ratio del video
//		//pueder p.e.: la mitad de la altura y la mitad del ancho
//		System.out.println("snapshot con tamano:" + player.getSnapshot(100, 100));
//		player.skipPosition(14f); //salta a la posicion actual + 14 en no se que unidades
//		player.skip(199); //salta al tiempo actual + 199 ms
//		player.setPosition(14f); //salta a la posicion 14
//		System.out.println("dimension :" +player.getVideoDimension());
}
