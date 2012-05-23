
package edu.eafit.maestria.activa.ui.player;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_instance_t;
import uk.co.caprica.vlcj.player.DefaultMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import edu.eafit.maestria.activa.ui.UIActivator;
import edu.eafit.maestria.activa.ui.utils.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class ActivaEmbeddedMediaPlayer extends DefaultMediaPlayer implements EmbeddedMediaPlayer {

	private static final LogUtil logger = LogUtil.getInstance(UIActivator.getDefault().getBundle().getSymbolicName());
	
	 /**
	   * Full-screen strategy implementation, may be <code>null</code>. 
	   */
	  private final FullScreenStrategy fullScreenStrategy;
	  
	  /**
	   * Listener implementation used to keep the overlay position and size in sync
	   * with the video surface.
	   */
	  private final OverlayComponentAdapter overlayComponentAdapter;
	  
	  /**
	   * Listener implementation used to keep the overlay visibility state in sync
	   * with the video surface.
	   */
	  private final OverlayWindowAdapter overlayWindowAdapter;
	  
	  /**
	   * Component to render the video to.
	   */
	  private CanvasVideoSurface videoSurface;

	  /**
	   * Optional overlay component.
	   */
	  private Window overlay;
	  
	  /**
	   * Track the requested overlay enabled/disabled state so it can be restored
	   * when needed.
	   */
	  private boolean requestedOverlay;
	  
	  /**
	   * Track whether or not the overlay should be restored when the video surface
	   * is shown/hidden. 
	   */
	  private boolean restoreOverlay;

	  /**
	   * Create a new media player.
	   * <p>
	   * Full-screen will not be supported.
	   * 
	   * @param libvlc native interface
	   * @param instance libvlc instance
	   */
	  public ActivaEmbeddedMediaPlayer(LibVlc libvlc, libvlc_instance_t instance) {
	    this(libvlc, instance, null);
	  }

	  /**
	   * Create a new media player.
	   * 
	   * @param libvlc native interface
	   * @param instance liblc instance
	   * @param fullScreenStrategy
	   */
	  public ActivaEmbeddedMediaPlayer(LibVlc libvlc, libvlc_instance_t instance, FullScreenStrategy fullScreenStrategy) {
	    super(libvlc, instance);
	    
	    this.fullScreenStrategy = fullScreenStrategy;
	    this.overlayComponentAdapter = new OverlayComponentAdapter();
	    this.overlayWindowAdapter = new OverlayWindowAdapter();
	  }

	  @Override
	  public void setVideoSurface(CanvasVideoSurface videoSurface) {
	    // Keep a hard reference to the video surface component
	    this.videoSurface = videoSurface;
	    // The video surface is not actually attached to the media player until the
	    // media is played
	  }

	  @Override
	  public void attachVideoSurface() {
	    if(videoSurface != null) {
	      // The canvas component must be visible at this point otherwise the call
	      // to the native library will fail
	      if(videoSurface.canvas().isVisible()) {
	        videoSurface.attach(libvlc, this);
	      }
	      else {
	        // This is an error
	        throw new IllegalStateException(Messages.VLC_VIDEO_SURFACE_ERROR);
	      }
	    }
	    else {
	      // This is not necessarily an error
	      logger.info(Messages.VLC_ATTACH_VIDEO_ERROR);
	    }
	  }

	  @Override
	  public void toggleFullScreen() {
	    if(fullScreenStrategy != null) {
	      setFullScreen(!fullScreenStrategy.isFullScreenMode());
	    }
	  }

	  @Override
	  public void setFullScreen(boolean fullScreen) {
	    if(fullScreenStrategy != null) {
	      if(fullScreen) {
	        fullScreenStrategy.enterFullScreenMode();
	      }
	      else {
	        fullScreenStrategy.exitFullScreenMode();
	      }
	    }
	  }
	  
	@Override
	  public boolean isFullScreen() {
	    if(fullScreenStrategy != null) {
	      return fullScreenStrategy.isFullScreenMode();
	    }
	    else {
	      return false;
	    }
	  }
	  
	@Override
	  public BufferedImage getVideoSurfaceContents() {
	    try {
	      Rectangle bounds = videoSurface.canvas().getBounds();
	      bounds.setLocation(videoSurface.canvas().getLocationOnScreen());
	      return new Robot().createScreenCapture(bounds);
	    } 
	    catch(Exception e) {
	      throw new RuntimeException(Messages.VLC_VIDEO_SURFACE_CONTENT_ERROR, e);
	    }
	  }
	  
	@Override
	  public Window getOverlay() {
	    return overlay;
	  }
	  
	@Override
	  public void setOverlay(Window overlay) {
	    if(videoSurface != null) {
	      // Disable the current overlay if there is one
	      enableOverlay(false);
	      // Remove the existing overlay if there is one
	      removeOverlay();
	      // Add the new overlay, but do not enable it
	      addOverlay(overlay);
	    }
	    else {
	      throw new IllegalStateException();
	    }
	  }

	@Override
	  public void enableOverlay(boolean enable) {
	    requestedOverlay = enable;
	    if(overlay != null) {
	      if(enable) {
	        if(!overlay.isVisible()) {
	          overlay.setLocation(videoSurface.canvas().getLocationOnScreen());
	          overlay.setSize(videoSurface.canvas().getSize());
	          Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	          window.addComponentListener(overlayComponentAdapter);
	          overlay.setVisible(true);
	        }
	      }
	      else {
	        if(overlay.isVisible()) {
	          overlay.setVisible(false);
	          Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	          window.removeComponentListener(overlayComponentAdapter);
	        }
	      }
	    }
	  }
	  
	@Override
	  public boolean overlayEnabled() {
	    return overlay != null && overlay.isVisible();
	  }
	  
	@Override
	  public void setEnableMouseInputHandling(boolean enable) {
	    libvlc.libvlc_video_set_mouse_input(mediaPlayerInstance(), enable ? 1 : 0);
	  }
	  
	@Override
	  public void setEnableKeyInputHandling(boolean enable) {
	    libvlc.libvlc_video_set_key_input(mediaPlayerInstance(), enable ? 1 : 0);
	  }
	  
	  /**
	   * Install an overlay component.
	   * 
	   * @param overlay overlay window
	   */
	  private void addOverlay(Window overlay) {
	    if(overlay != null) {
	      this.overlay = overlay;
	      Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	      if(window != null) {
	        window.addWindowListener(overlayWindowAdapter);
	      }
	      else {
	        // This should not be possible
	        logger.warning(Messages.VLC_ADD_OVERLAY_ERROR);
	      }
	    }
	  }
	  
	  /**
	   * Remove the overlay component.
	   * 
	   * @param overlay overlay window
	   */
	  private void removeOverlay() {
	    if(overlay != null) {
	      Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	      window.removeWindowListener(overlayWindowAdapter);
	      overlay = null;
	    }
	  }
	  
	  @Override
	  protected final void onBeforePlay() {
	    attachVideoSurface();
	  }
	  
	  /**
	   * Component event listener to keep the overlay component in sync with the
	   * video surface component.
	   */
	  private final class OverlayComponentAdapter extends ComponentAdapter {

	    @Override
	    public void componentResized(ComponentEvent e) {
	      overlay.setSize(videoSurface.canvas().getSize());
	    }

	    @Override
	    public void componentMoved(ComponentEvent e) {
	      overlay.setLocation(videoSurface.canvas().getLocationOnScreen());
	    }

	    @Override
	    public void componentShown(ComponentEvent e) {
	      showOverlay();
	    }

	    @Override
	    public void componentHidden(ComponentEvent e) {
	      hideOverlay();
	    }
	  }
	  
	  /**
	   * Window event listener to hide the overlay when the video window is hidden,
	   * and vice versa.
	   */
	  private final class OverlayWindowAdapter extends WindowAdapter {
	    
	    @Override
	    public void windowIconified(WindowEvent e) {
	      // Nothing, this is taken care of by "windowDeactivated"
	    }

	    @Override
	    public void windowDeiconified(WindowEvent e) {
	      showOverlay();
	    }
	    
	    @Override
	    public void windowDeactivated(WindowEvent e) {
	      hideOverlay();
	    }

	    @Override
	    public void windowActivated(WindowEvent e) {
	      showOverlay();
	    }
	  }
	  
	  /**
	   * Make the overlay visible.
	   */
	  private void showOverlay() {
	    if(restoreOverlay) {
	      enableOverlay(true);
	    }
	  }
	  
	  /**
	   * Hide the overlay.
	   */
	  private void hideOverlay() {
	    if(requestedOverlay) {
	      restoreOverlay = true;
	      enableOverlay(false);
	    }
	    else {
	      restoreOverlay = false;
	    }
	  }
}
