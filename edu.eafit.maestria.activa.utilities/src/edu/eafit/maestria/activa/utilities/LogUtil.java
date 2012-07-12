/*******************************************************************************
 * Copyright (c) 2009 Siemens AG, KolbW@re
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bernd Kolb - initial API and implementation
 *    Kai Tödter  - integration
 *******************************************************************************/

package edu.eafit.maestria.activa.utilities;

import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * A Utility class for logging
 */

//sets the level used when logging messages to the eclipse log.
//NONE
//FATAL
//ERROR - enables logging only ERROR messages.
//WARNING - enables logging of ERROR and WARNING messages.
//INFO - enables logging of ERROR, WARNING and INFO messages.
//DEBUG - enables logging of all messages (default value)

public class LogUtil {

	private static Map<String, LogUtil> loggers = new HashMap<String, LogUtil>();

	private String bundleID;
	private ILog logger;
	
	/**
	 * Log level, used only if the -Dactiva.log= system property has not already
	 * been set.
	 */
	private static Level threshold = Level.DEBUG;
	
	static {
        String logProperty = System.getProperty(Constants.Config.ACTIVA_LOG_PROPERTY);
		if(StringUtils.isNotBlank(logProperty)) {
            threshold = Level.valueOf(logProperty);
        }
	}
	
	public static Level getLevel(){
		return threshold;
	}
	
	public enum Level {
        NONE(0), FATAL(1), ERROR(2), WARN(3), INFO(4), DEBUG(5);
        
        private int id;
        
        private Level(int id){
        	this.id = id;
        }
        
        public int getId(){
        	return id;
        }
    }
	
	private LogUtil(String bundleID) {
		if (StringUtils.isBlank(bundleID)) {
			this.bundleID = Activator.getDefault().getBundle().getSymbolicName();
		}
		else {
			this.bundleID = bundleID;
		}
		logger = Platform.getLog(Platform.getBundle(bundleID));
	}
	
	public static LogUtil getInstance(String bundleID){
		if (loggers.containsKey(bundleID))
			return loggers.get(bundleID);
		
		LogUtil logger = new LogUtil(bundleID);
		loggers.put(bundleID, logger);
		return logger;
	}
	
	public void fatal(Throwable t) {
        log(Level.FATAL, t, Status.ERROR, Status.CANCEL, t.getMessage());
    }
    
    public void fatal(String message, Object...objs) {
        log(Level.FATAL, null, Status.ERROR, Status.CANCEL, message, objs);
    }
    
    public void fatal(Throwable t, String message, Object...objs) {
    	log(Level.FATAL, t, Status.ERROR, Status.CANCEL, message, objs);
    }
    
	public void error(Throwable t) {
        log(Level.ERROR, t, Status.ERROR, Status.OK, t.getMessage());
    }

	public void error(String message, Object...objs) {
        log(Level.ERROR, null, Status.ERROR, Status.OK, message, objs);
    }

	public void error(Throwable t, String message, Object...objs) {
        log(Level.ERROR, t, Status.ERROR, Status.OK, message, objs);
    }
    
    public void warning(Throwable t) {
        log(Level.WARN, t, Status.WARNING, Status.OK, t.getMessage());
    }

    public void warning(String message, Object...objs) {
        log(Level.WARN, null, Status.WARNING, Status.OK, message, objs);
    }
    
    public void warning(Throwable t, String message, Object...objs) {
        log(Level.WARN, t, Status.WARNING, Status.OK, message, objs);
    }
    
    public void info(String message, Object...objs) {
        log(Level.INFO, null, Status.INFO, Status.OK, message, objs);
    }

    private void log(Level level, Throwable t, int severity, int code, String message, Object...objs) {
    	if (level.getId() <= threshold.getId()) {
    		StackTraceElement el = getLine();
	    	String location = new Formatter().format("(%s:%d)", el.getFileName(), el.getLineNumber()).toString();
	    	String newMessage = StringUtils.isBlank(message) ? "" : String.format(message, objs);
	        String finalMessage = new Formatter().format("acTiVa: %-40s | %-5s | %s\n", location, level, newMessage).toString();
	        logger.log(new Status(severity, bundleID, code, finalMessage, t));
    	}
    }
    
    private static StackTraceElement getLine() {
        Throwable t = new Throwable();
        t.fillInStackTrace();
        StackTraceElement[] els = t.getStackTrace();
        return els[3]; // Take care!
    }
}
