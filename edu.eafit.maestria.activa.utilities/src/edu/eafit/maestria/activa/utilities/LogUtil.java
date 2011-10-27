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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * A Utility class for logging
 */
//TODO usar las propiedades de eclipse para el log

//eclipse.log.level
//sets the level used when logging messages to the eclipse log.
//ERROR - enables logging only ERROR messages.
//WARNING - enables logging of ERROR and WARNING messages.
//INFO - enables logging of ERROR, WARNING and INFO messages.
//ALL - enables logging of all messages (default value)
//eclipse.log.backup.max
//the max number of backup log files to allow. The oldest backup log file will be deleted after the max number of backup log files is reached as a result of rotating the log file. The default value is "10". A negative or zero value will cause the default value to be used.
//eclipse.log.size.max
//the max size in Kb that the log file is allowed to grow. The log file is rotated when the file size exceeds the max size. The default value is "1000". A negative value will cause the default value to be used. A zero value indicates no max log size.
//eclipse.noExtensionMunging
//if "true", legacy registry extension are left as-is. By default such extensions are updated to use the new extension point ids found in Eclipse 3.0.

public class LogUtil {

	private static Map<String, LogUtil> loggers = new HashMap<String, LogUtil>();

	private Class<?> clazz;
	private String bundleID;
	private ILog logger;
	
	private LogUtil(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	private LogUtil(String bundleID, Class<?> clazz) {
		if (StringUtils.isBlank(bundleID)) {
			this.bundleID = Activator.getDefault().getBundle().getSymbolicName();
		}
		else {
			this.bundleID = bundleID;
		}
		this.clazz = clazz;
		logger = Platform.getLog(Platform.getBundle(bundleID));
	}
	
	public static LogUtil getInstance(String bundleID, Class<?> clazz){
		if (loggers.containsKey(clazz.getName()))
			return loggers.get(clazz.getName());
		
		LogUtil logger = new LogUtil(bundleID, clazz);
		loggers.put(clazz.getName(), logger);
		return logger;
	}
	
	public void logError(Throwable t) {
        logError(t.getMessage(), t);
    }

    public void logError(String message, Throwable t) {
        log(message, t, Status.ERROR, Status.OK);
    }

    public void logWarning(String message) {
        log(message, null, Status.WARNING, Status.OK);
    }
    
    public void logWarning(String message, Throwable t) {
        log(message, t, Status.WARNING, Status.OK);
    }
    
    public void logInfo(String message) {
        log(message, null, Status.INFO, Status.OK);
    }

    public void logError(String message) {
        logError(message, null);
    }
    
    public void logFatal(String message, Throwable t) {
        log(message, t, Status.ERROR, Status.CANCEL);
    }

    public void logFatal(Throwable t) {
        logFatal(t.getMessage(), t);
    }
    
    private void log(String message, Throwable t, int serverity, int code) {
        logger.log(new Status(serverity, bundleID, code, "[" + clazz.getName() +"] " + message, t));
        
        if (t != null)
        	t.printStackTrace();
    }
}
