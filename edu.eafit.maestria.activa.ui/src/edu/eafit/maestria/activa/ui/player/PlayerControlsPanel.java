package edu.eafit.maestria.activa.ui.player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.wb.swt.ResourceManager;

import uk.co.caprica.vlcj.binding.LibVlcConst;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.handlers.player.SaveSnapshotHandler;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class PlayerControlsPanel extends Composite {

	LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName(), PlayerControlsPanel.class);
	
	private static final int VLC_OFFSET = 15;
	private static final long SKIP_TIME_MS = 10 * 1000;

	private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	private final EmbeddedMediaPlayer mediaPlayer;

	private Label timeLabel;
	private Scale positionScale;
	private Label sceneLabel;
	private Label frameLabel;
	
	private Button previousFrameButton;
	private Button rewindButton;
	private Button stopButton;
	private Button playButton;
	private Button fastForwardButton;
	private Button nextFrameButton;
	private Button toggleMuteButton;
	private Scale volumeScale;
	private Button markSceneButton;
	private Long currentFrame;

	private boolean mousePressedPlaying = false;
	private boolean frameByFrame = false;

	public PlayerControlsPanel(Composite parent, EmbeddedMediaPlayer mediaPlayer) {
		super(parent, SWT.BORDER);
		setLayout(new GridLayout(1, true));

		this.mediaPlayer = mediaPlayer;
		
		createTopPanel();
		createBottomPanel();
		registerListeners();
		setEnabled(false);
		
		executorService.scheduleAtFixedRate(new UpdateControls(mediaPlayer), 0L, 250L, TimeUnit.MILLISECONDS);
	}

	private void createTopPanel() {
		Composite topPanel = new Composite(this, SWT.NONE);
		topPanel.setLayout(new GridLayout(4,false));
		
		timeLabel = new Label(topPanel, SWT.NONE);
		timeLabel.setText("hh:mm:ss");

		positionScale = new Scale(topPanel, SWT.HORIZONTAL);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		topPanel.setLayoutData(gridData);
		
		positionScale.setLayoutData(gridData);
		positionScale.setMinimum(0);
		positionScale.setMaximum(1000);
		positionScale.setIncrement(1);
		positionScale.setToolTipText(Messages.COMMAND_FILE_NEW_PAGE_WIZARD_DESCRIPTION);

		sceneLabel = new Label(topPanel, SWT.NONE);
		sceneLabel.setText("1/1");
		frameLabel = new Label(topPanel, SWT.NONE);
		frameLabel.setText("0000000000");
	}
	
	public void setEnabled(boolean enabled){
		if (!enabled) {
			timeLabel.setText("hh:mm:ss");
			positionScale.setSelection(0);
			volumeScale.setSelection(0);
			sceneLabel.setText("1/1");
			frameLabel.setText("0000000000");
		}
		super.setEnabled(enabled);
	}

	private void createBottomPanel() {
		Composite bottomPanel = new Composite(this, SWT.FLAT);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.fill = true;
		bottomPanel.setLayout(rowLayout);
		previousFrameButton = new Button(bottomPanel, SWT.PUSH);
		previousFrameButton.setLayoutData(new RowData(54, 51));
		
		previousFrameButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/previousFrame-48.png"));
		previousFrameButton.setToolTipText(Messages.PLAYER_PREVIOUS_FRAME);

		rewindButton = new Button(bottomPanel, SWT.PUSH);
		rewindButton.setLayoutData(new RowData(54, 51));
		rewindButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/rewind-48.png"));
		rewindButton.setToolTipText(Messages.PLAYER_REWIND);

		stopButton = new Button(bottomPanel, SWT.PUSH);
		stopButton.setLayoutData(new RowData(54, 51));
		stopButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/stop-48.png"));
		stopButton.setToolTipText(Messages.PLAYER_STOP);

		playButton = new Button(bottomPanel, SWT.PUSH);
		playButton.setLayoutData(new RowData(54, 51));
		playButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/play-48.png"));
		playButton.setToolTipText(Messages.PLAYER_PLAY_PAUSE);

		fastForwardButton = new Button(bottomPanel, SWT.PUSH);
		fastForwardButton.setLayoutData(new RowData(54, 51));
		fastForwardButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/forward-48.png"));
		fastForwardButton.setToolTipText(Messages.PLAYER_FORWARD);

		nextFrameButton = new Button(bottomPanel, SWT.PUSH);
		nextFrameButton.setLayoutData(new RowData(54, 51));
		nextFrameButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/nextFrame-48.png"));
		nextFrameButton.setToolTipText(Messages.PLAYER_NEXT_FRAME);

		toggleMuteButton = new Button(bottomPanel, SWT.PUSH);
		toggleMuteButton.setLayoutData(new RowData(54, 51));
		toggleMuteButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/mute-48.png"));
		toggleMuteButton.setToolTipText(Messages.PLAYER_MUTE);

		markSceneButton = new Button(bottomPanel, SWT.PUSH);
		markSceneButton.setLayoutData(new RowData(54, 51));
		markSceneButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/NeedleWhite-icon 48.png"));
		markSceneButton.setToolTipText(Messages.PLAYER_MARK_SCENE);

		volumeScale = new Scale(bottomPanel, SWT.HORIZONTAL);
		volumeScale.setLayoutData(new RowData(300, 51));
		volumeScale.setMinimum(LibVlcConst.MIN_VOLUME);
		volumeScale.setMaximum(LibVlcConst.MAX_VOLUME);
		volumeScale.setToolTipText(Messages.PLAYER_VOLUME);
	}

	/**
	 * Broken out position setting, handles updating mediaPlayer
	 */
	private void setSliderBasedPosition() {
		if (!mediaPlayer.isSeekable()) {
			return;
		}
		float positionValue = (float) positionScale.getSelection() / 1000.0f;
		// Avoid end of file freeze-up
		if (positionValue > 0.99f) {
			positionValue = 0.99f;
		}
		mediaPlayer.setPosition(positionValue);
	}

	private void updateUIState() {
		long time = mediaPlayer.getTime();
		int position = (int) (mediaPlayer.getPosition() * 1000.0f);
		int chapter = mediaPlayer.getChapter();
		int chapterCount = mediaPlayer.getChapterCount();
		updateTime(time);
		updatePosition(position);
		updateScene(chapter, chapterCount);
		updateFrames(time);
	}

	private void updateFrames(long time) {
		double frame = Math.ceil((mediaPlayer.getFps()/1000)*time);
		currentFrame = Double.valueOf(frame).longValue();
		
		frameLabel.setText(Long.toString(currentFrame));
	}

	private void skip(long skipTime) {
		// Only skip time if can handle time setting
		if (mediaPlayer.getLength() > 0) {
			mediaPlayer.skip(skipTime);
			updateUIState();
		}
	}

	private void registerListeners() {
		mediaPlayer.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
			@Override
			public void playing(final MediaPlayer mediaPlayer) {
				Display.getDefault().syncExec(new Runnable () {
					@Override
					public void run(){
						volumeScale.setSelection(mediaPlayer.getVolume());
					}
				});
			}
		});

		positionScale.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				setSliderBasedPosition();
				updateUIState();
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				if (mediaPlayer.isPlaying()) {
					mousePressedPlaying = true;
				} else {
					mousePressedPlaying = false;
				}
				setSliderBasedPosition();
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}
			
			
		});

		previousFrameButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				pause();
				double frame = Math.ceil((mediaPlayer.getFps()/1000)*mediaPlayer.getTime());
				currentFrame = Double.valueOf(frame).longValue();
				if (currentFrame != null && currentFrame.longValue() > 0) {
					
					long frameLength = Double.valueOf(1000/mediaPlayer.getFps()).longValue();
					long previousFrame = 0;
					long helperFrame = 0;
					long newTime = mediaPlayer.getTime() - frameLength;
					do {
						previousFrame = Double.valueOf(Math.ceil((mediaPlayer.getFps()/1000)*newTime)).longValue();
						helperFrame = Double.valueOf(Math.ceil((mediaPlayer.getFps()/1000)*(newTime+VLC_OFFSET))).longValue();
						if (previousFrame != helperFrame) {
							newTime -= VLC_OFFSET;
						} 
						
					} while (previousFrame >= currentFrame || helperFrame >= currentFrame);
					//mediaPlayer.skip(-(mediaPlayer.getTime() - newTime)); 
					mediaPlayer.setTime(newTime); 
					updateUIState();
					frameByFrame = true;
				}
			}
		});

		rewindButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				skip(-SKIP_TIME_MS);
			}
		});

		stopButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				mediaPlayer.stop();
				updateUIState();
				playButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/play-48.png"));
			}
		});

		playButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				tooglePlay(mediaPlayer.isPlaying());
			}
		});

		fastForwardButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				skip(SKIP_TIME_MS);
			}
		});

		nextFrameButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				pause();
				double frame = Math.ceil((mediaPlayer.getFps()/1000)*mediaPlayer.getTime());
				currentFrame = Double.valueOf(frame).longValue();
				if (currentFrame != null && currentFrame.longValue() < Math.ceil(mediaPlayer.getFps()/1000)*mediaPlayer.getLength()) {
				
					long frameLength = Double.valueOf(1000/mediaPlayer.getFps()).longValue();
					long nextFrame = currentFrame + 1;
					long newTime = currentFrame * frameLength;
					long aproxNextFrame = Double.valueOf(Math.ceil((mediaPlayer.getFps()/1000)*newTime)).longValue();
					while (aproxNextFrame < nextFrame) {
						aproxNextFrame = Double.valueOf(Math.ceil((mediaPlayer.getFps()/1000)*++newTime)).longValue();
					} 
					mediaPlayer.setTime(newTime);
					updateUIState();
					frameByFrame = true;
				}
			}
		});

		toggleMuteButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				mediaPlayer.mute();
			}
		});

		volumeScale.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
		      	mediaPlayer.setVolume(volumeScale.getSelection());
			}
		});

		markSceneButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				try {
					IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
					handlerService.executeCommand(SaveSnapshotHandler.commandId, null);
				} catch (Exception ex) {
					logger.logFatal(ex);
					PlatformUI.getWorkbench().close();
				}
			}
		});

	}

	private final class UpdateControls implements Runnable {

		private final EmbeddedMediaPlayer mediaPlayer;

		private UpdateControls(EmbeddedMediaPlayer mediaPlayer) {
			this.mediaPlayer = mediaPlayer;
		}

		@Override
		public void run() {
			// Updates to user interface components must be executed on the
			// Event
			// Dispatch Thread
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					long time = mediaPlayer.getTime();
					int position = (int) (mediaPlayer.getPosition() * 1000.0f);
					int chapter = mediaPlayer.getChapter();
					int chapterCount = mediaPlayer.getChapterCount();
					updateTime(time);
					updatePosition(position);
					updateScene(chapter, chapterCount);
					updateFrames(time);
				}
			});
		}
	}
	
	private void updateTime(long millis) {
		String s = String.format("%02d:%02d:%02d",
				TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)	- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis)	- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		timeLabel.setText(s);
	}

	private void updatePosition(int value) {
		positionScale.setSelection(value);
	}

	private void updateScene(int scene, int sceneCount) {
		String s = sceneCount != -1 ? (scene + 1) + "/" + sceneCount : "-";
		sceneLabel.setText(s);
	}

	private void tooglePlay(boolean isPlaying){
		if (isPlaying) {
			mediaPlayer.pause();
			playButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/play-48.png"));
		}
		else {
			mediaPlayer.play();
			playButton.setImage(ResourceManager.getPluginImage(UIActivator.getDefault().getBundle().getSymbolicName(), "icons/48/pause-48.png"));
		}
	}
	
	public void pause(){
		if (mediaPlayer.isPlaying())
			tooglePlay(true);
	}
	
	public Long getCurrentFrame(){
		return currentFrame;
	}
	
	public boolean isFrameByFrame(){
		return frameByFrame;
	}
	
	public void resetFrameByFrame(){
		frameByFrame = false;
	}
}
