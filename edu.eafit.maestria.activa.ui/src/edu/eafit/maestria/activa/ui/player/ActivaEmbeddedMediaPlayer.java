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
import uk.co.caprica.vlcj.logger.Logger;
import uk.co.caprica.vlcj.player.DefaultMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.FullScreenStrategy;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

public class ActivaEmbeddedMediaPlayer extends DefaultMediaPlayer implements EmbeddedMediaPlayer {

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

	//  @Override
	  public void setVideoSurface(CanvasVideoSurface videoSurface) {
	    Logger.debug("setVideoSurface(videoSurface={})", videoSurface);
	    // Keep a hard reference to the video surface component
	    this.videoSurface = videoSurface;
	    // The video surface is not actually attached to the media player until the
	    // media is played
	  }

	//  @Override
	  public void attachVideoSurface() {
	    Logger.debug("attachVideoSurface()");
	    if(videoSurface != null) {
	      // The canvas component must be visible at this point otherwise the call
	      // to the native library will fail
	      if(videoSurface.canvas().isVisible()) {
	        videoSurface.attach(libvlc, this);
	      }
	      else {
	        // This is an error
	        throw new IllegalStateException("The video surface is not visible");
	      }
	    }
	    else {
	      // This is not necessarily an error
	      Logger.debug("Can't attach video surface since no video surface has been set");
	    }
	  }

	//  @Override
	  public void toggleFullScreen() {
	    Logger.debug("toggleFullScreen()");
	    if(fullScreenStrategy != null) {
	      setFullScreen(!fullScreenStrategy.isFullScreenMode());
	    }
	  }

	//  @Override
	  public void setFullScreen(boolean fullScreen) {
	    Logger.debug("setFullScreen(fullScreen={})", fullScreen);
	    if(fullScreenStrategy != null) {
	      if(fullScreen) {
	        fullScreenStrategy.enterFullScreenMode();
	      }
	      else {
	        fullScreenStrategy.exitFullScreenMode();
	      }
	    }
	  }
	  
	//  @Override
	  public boolean isFullScreen() {
	    Logger.debug("isFullScreen()");
	    if(fullScreenStrategy != null) {
	      return fullScreenStrategy.isFullScreenMode();
	    }
	    else {
	      return false;
	    }
	  }
	  
	//  @Override
	  public BufferedImage getVideoSurfaceContents() {
	    Logger.debug("getVideoSurfaceContents()");
	    try {
	      Rectangle bounds = videoSurface.canvas().getBounds();
	      bounds.setLocation(videoSurface.canvas().getLocationOnScreen());
	      return new Robot().createScreenCapture(bounds);
	    } 
	    catch(Exception e) {
	      throw new RuntimeException("Failed to get video surface contents", e);
	    }
	  }
	  
	//  @Override
	  public Window getOverlay() {
	    Logger.debug("getOverlay()");
	    return overlay;
	  }
	  
	//  @Override
	  public void setOverlay(Window overlay) {
	    Logger.debug("setOverlay(overlay={})", overlay);
	    if(videoSurface != null) {
	      // Disable the current overlay if there is one
	      enableOverlay(false);
	      // Remove the existing overlay if there is one
	      removeOverlay();
	      // Add the new overlay, but do not enable it
	      addOverlay(overlay);
	    }
	    else {
	      throw new IllegalStateException("Can't set an overlay when there's no video surface");
	    }
	  }

	//  @Override
	  public void enableOverlay(boolean enable) {
	    Logger.debug("enableOverlay(enable={})", enable);
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
	  
	//  @Override
	  public boolean overlayEnabled() {
	    Logger.debug("overlayEnabled()");
	    return overlay != null && overlay.isVisible();
	  }
	  
	//  @Override
	  public void setEnableMouseInputHandling(boolean enable) {
	    Logger.debug("setEnableMouseInputHandling(enable={})", enable);
	    libvlc.libvlc_video_set_mouse_input(mediaPlayerInstance(), enable ? 1 : 0);
	  }
	  
	//  @Override
	  public void setEnableKeyInputHandling(boolean enable) {
	    Logger.debug("setEnableKeyInputHandling(enable={})", enable);
	    libvlc.libvlc_video_set_key_input(mediaPlayerInstance(), enable ? 1 : 0);
	  }
	  
	  /**
	   * Install an overlay component.
	   * 
	   * @param overlay overlay window
	   */
	  private void addOverlay(Window overlay) {
	    Logger.debug("addOverlay(overlay={})", overlay);
	    if(overlay != null) {
	      this.overlay = overlay;
	      Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	      if(window != null) {
	        window.addWindowListener(overlayWindowAdapter);
	      }
	      else {
	        // This should not be possible
	        Logger.warn("Failed to find a Window ancestor for the video surface Canvas");
	      }
	    }
	  }
	  
	  /**
	   * Remove the overlay component.
	   * 
	   * @param overlay overlay window
	   */
	  private void removeOverlay() {
	    Logger.debug("removeOverlay()");
	    if(overlay != null) {
	      Window window = (Window)SwingUtilities.getAncestorOfClass(Window.class, videoSurface.canvas());
	      window.removeWindowListener(overlayWindowAdapter);
	      overlay = null;
	    }
	  }
	  
	  @Override
	  protected final void onBeforePlay() {
	    Logger.debug("onBeforePlay()");
	    attachVideoSurface();
	  }
	  
	  /**
	   * Component event listener to keep the overlay component in sync with the
	   * video surface component.
	   */
	  private final class OverlayComponentAdapter extends ComponentAdapter {

	    @Override
	    public void componentResized(ComponentEvent e) {
	      Logger.trace("componentResized(e={})", e);
	      overlay.setSize(videoSurface.canvas().getSize());
	    }

	    @Override
	    public void componentMoved(ComponentEvent e) {
	      Logger.trace("componentMoved(e={})", e);
	      overlay.setLocation(videoSurface.canvas().getLocationOnScreen());
	    }

	    @Override
	    public void componentShown(ComponentEvent e) {
	      Logger.trace("componentShown(e={})", e);
	      showOverlay();
	    }

	    @Override
	    public void componentHidden(ComponentEvent e) {
	      Logger.trace("componentHidden(e={})", e);
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
	      Logger.trace("windowIconified(e={})", e);
	      // Nothing, this is taken care of by "windowDeactivated"
	    }

	    @Override
	    public void windowDeiconified(WindowEvent e) {
	      Logger.trace("windowDeiconified(e={})", e);
	      showOverlay();
	    }
	    
	    @Override
	    public void windowDeactivated(WindowEvent e) {
	      Logger.trace("windowDeactivated(e={})", e);
	      hideOverlay();
	    }

	    @Override
	    public void windowActivated(WindowEvent e) {
	      Logger.trace("windowActivated(e={})", e);
	      showOverlay();
	    }
	  }
	  
	  /**
	   * Make the overlay visible.
	   */
	  private void showOverlay() {
	    Logger.trace("showOverlay()");
	    if(restoreOverlay) {
	      enableOverlay(true);
	    }
	  }
	  
	  /**
	   * Hide the overlay.
	   */
	  private void hideOverlay() {
	    Logger.trace("hideOverlay()");
	    if(requestedOverlay) {
	      restoreOverlay = true;
	      enableOverlay(false);
	    }
	    else {
	      restoreOverlay = false;
	    }
	  }
}
