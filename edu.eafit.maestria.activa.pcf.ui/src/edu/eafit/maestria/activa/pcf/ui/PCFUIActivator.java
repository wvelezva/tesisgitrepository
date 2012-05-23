package edu.eafit.maestria.activa.pcf.ui;

import org.osgi.framework.BundleContext;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.pcf.services.PCFServicesImpl;
import edu.eafit.maestria.activa.utilities.Activator;

public class PCFUIActivator extends Activator {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		Container.add(PCFServicesImpl.class);
	}
}
