package edu.eafit.maestria.activa.ui.player;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import uk.co.caprica.vlcj.logger.Logger;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.NativeLibrary;

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

	/**
	 * Log level, used only if the -Dvlcj.log= system property has not already
	 * been set.
	 */
	private static final String VLCJ_LOG_LEVEL = "INFO";

	/**
	 * Change this to point to your own vlc installation, or comment out the
	 * code if you want to use your system default installation.
	 * <p>
	 * This is a bit more explicit than using the -Djna.library.path= system
	 * property.
	 */
	private static final String NATIVE_LIBRARY_SEARCH_PATH = "/Users/wvelezva/Maestria/vlc-2.1.0/VLC.app/Contents/MacOS/lib/";

	/**
	 * Set to true to dump out native JNA memory structures.
	 */
	private static final String DUMP_NATIVE_MEMORY = "true";

	protected static List<String> vlcArgs = new ArrayList<String>();
	/**
	 * Static initialisation.
	 */
	static {
		if (StringUtils.isBlank(System.getProperty("vlcj.log"))) {
			System.setProperty("vlcj.log", VLCJ_LOG_LEVEL);
			System.setProperty("sun.awt.noerasebackground", "true");
		}

		if (StringUtils.isBlank(System.getProperty("jna.library.path")) && StringUtils.isNotBlank(NATIVE_LIBRARY_SEARCH_PATH)) {
			Logger.info("Explicitly adding JNA native library search path: '{}'", NATIVE_LIBRARY_SEARCH_PATH);
			NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),	NATIVE_LIBRARY_SEARCH_PATH);
		}

		System.setProperty("jna.dump_memory", DUMP_NATIVE_MEMORY);
		
	    vlcArgs.add("--no-plugins-cache");
	    vlcArgs.add("--no-video-title-show");
	    vlcArgs.add("--no-snapshot-preview");
	    vlcArgs.add("--auto-preparse");
	    vlcArgs.add("--intf");
	    vlcArgs.add("--no-xlib");
	    vlcArgs.add("--no-osd");

	    if (!"DEBUG".equals(System.getProperty("vlcj.log")) && !"TRACE".equals(System.getProperty("vlcj.log"))) {
		    vlcArgs.add("--quiet");
		    vlcArgs.add("--quiet-synchro");
	    } else {
	    	vlcArgs.add("-vvv");
	    }
	    
	    if (RuntimeUtil.isMac())
	    	vlcArgs.add("--vout=macosx");
	    
	    vlcArgs.add("dummy");
	}
}
