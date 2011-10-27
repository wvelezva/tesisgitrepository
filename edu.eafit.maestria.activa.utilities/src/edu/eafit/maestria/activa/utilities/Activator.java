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
 *    Kai Tödter - integration
 *******************************************************************************/

package edu.eafit.maestria.activa.utilities;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Activator extends Plugin {

    // The shared instance.
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
        plugin = this;
    }

    /**
     * This method is called upon plug-in activation
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
    }

    /**
     * This method is called when the plug-in is stopped
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        super.stop(context);
        plugin = null;
    }

    /**
     * Returns the shared instance.
     */
    public static Activator getDefault() {
        return plugin;
    }

}
