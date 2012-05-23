package edu.eafit.maestria.activa.ui.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.NativeLibrary;

import edu.eafit.maestria.activa.utilities.Constants;
import edu.eafit.maestria.activa.utilities.LogUtil;

/**
 * Base class for tests.
 * <p>
 * This makes it a lot easier to switch vlc versions or vlc install directories
 * without having to change system properties on a lot of IDE application run-
 * configurations.
 * <p>
 * Explicitly setting a search path forces JNA to search that path
 * <em>first</em>.
 * <p>
 * The search path should be the directory that contains libvlc.so and
 * libvlccore.so.
 * <p>
 * If you do not explicitly set the search path, the system search path will be
 * used.
 * <p>
 * You can also set the log level here.
 */
public abstract class BaseVlcj {

	private static final String VLCJ_LOG_PROPERTY = "vlcj.log";
	private static final String SUN_AWT_NOERASEBACKGROUND = "sun.awt.noerasebackground";
	private static final String JNA_LIBRARY_PATH = "jna.library.path";
	private static final String JNA_DUMP_MEMORY = "jna.dump_memory";

	/**
	 * Change this to point to your own vlc installation, or comment out the
	 * code if you want to use your system default installation.
	 * <p>
	 * This is a bit more explicit than using the -Djna.library.path= system
	 * property.
	 */
	private static final String NATIVE_LIBRARY_SEARCH_PATH = "/Users/wvelezva/Maestria/vlc-2.1.0/VLC.app/Contents/MacOS/lib/";

	private static final String[] defaultArgs = {"--no-plugins-cache", 
												"--no-video-title-show",
												"--no-snapshot-preview",
												"--auto-preparse",
												"--intf",
												"--no-xlib",
												"--no-osd",
												"--width=" + Constants.Player.WIDTH,
												"--height=" + Constants.Player.HEIGHT};
	private static final String[] quietArgs = {"--quiet","--quiet-synchro"};
	private static final String VERBOSE = "-vvv";
	private static final String VOUT_MACOSX = "--vout=macosx";
	private static final String DUMMY = "dummy";
	
	protected static List<String> vlcArgs = new ArrayList<String>(Arrays.asList(defaultArgs));
	
	/**
	 * Static initialisation.
	 */
	static {
		System.setProperty(VLCJ_LOG_PROPERTY, LogUtil.getLevel().toString());
		//	 Do not erase the backgound during moving windows "gray fog", this is to avoid flickering
		System.setProperty(SUN_AWT_NOERASEBACKGROUND, Boolean.TRUE.toString());
		
		if (StringUtils.isBlank(System.getProperty(JNA_LIBRARY_PATH)) 
				&& StringUtils.isNotBlank(NATIVE_LIBRARY_SEARCH_PATH)) {
			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),	NATIVE_LIBRARY_SEARCH_PATH);
		}

		/**
		 * Set to true to dump out native JNA memory structures.
		 */
		System.setProperty(JNA_DUMP_MEMORY, Boolean.TRUE.toString());
		
	    if (!LogUtil.Level.DEBUG.toString().equals(System.getProperty(VLCJ_LOG_PROPERTY))) {
		    vlcArgs.addAll(Arrays.asList(quietArgs));
	    } else {
	    	vlcArgs.add(VERBOSE);
	    }
	    
	    if (RuntimeUtil.isMac())
	    	vlcArgs.add(VOUT_MACOSX);
	    
	    vlcArgs.add(DUMMY);
	}
}
