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
import org.eclipse.wb.swt.ResourceManager;

import uk.co.caprica.vlcj.binding.LibVlcConst;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;

public class PlayerControlsPanel extends Composite {

	private static final int SKIP_TIME_MS = 10 * 1000;

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

	private boolean mousePressedPlaying = false;

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
//		if (!mediaPlayer.isPlaying()) {
//			// Resume play or play a few frames then pause to show current
//			// position in video
//			mediaPlayer.play();
//			if (!mousePressedPlaying) {
//				try {
//					// Half a second probably gets an iframe
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// Don't care if unblocked early
//				}
//				mediaPlayer.pause();
//			}
//		}
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
		double currentFrame = Math.floor((mediaPlayer.getFps()/1000)*time);
		long frame = Double.valueOf(currentFrame).longValue();
		frameLabel.setText(Long.toString(frame));
	}

	private void skip(int skipTime) {
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
				Display.getDefault().asyncExec(new Runnable () {
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
					mediaPlayer.pause();
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
				double floor = Math.floor(1000/mediaPlayer.getFps());
				skip(-Double.valueOf(floor).intValue());
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
				//mediaPlayer.setPosition(0f);
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
				mediaPlayer.nextFrame();
//				System.out.println("time:" +mediaPlayer.getTime());
//				System.out.println("position:" + mediaPlayer.getPosition() * 1000.0f);
//				System.out.println("frame:" + Math.floor((mediaPlayer.getFps()/1000)*mediaPlayer.getTime()));
				updateUIState();
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
				mediaPlayer.saveSnapshot();
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
			final long time = mediaPlayer.getTime();
			
			final int position = (int) (mediaPlayer.getPosition() * 1000.0f);
			final int chapter = mediaPlayer.getChapter();
			final int chapterCount = mediaPlayer.getChapterCount();

			// Updates to user interface components must be executed on the
			// Event
			// Dispatch Thread
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					if (mediaPlayer.isPlaying()) {
						updateTime(time);
						updatePosition(position);
						updateScene(chapter, chapterCount);
						updateFrames(time);
					}
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
			updateUIState();
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
}
