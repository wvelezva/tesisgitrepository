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

package edu.eafit.maestria.activa.dao.hibernate;

import org.osgi.framework.BundleContext;

import edu.eafit.maestria.activa.dao.hibernate.utils.HibernateUtil;
import edu.eafit.maestria.activa.utilities.Activator;



/**
 * The main plugin class to be used in the desktop.
 */
public class DAOActivator extends Activator {

	@Override
    public void stop(BundleContext context) throws Exception {
		HibernateUtil.close();
        super.stop(context);
    }
}