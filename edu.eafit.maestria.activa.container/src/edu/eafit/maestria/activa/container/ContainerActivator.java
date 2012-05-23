package edu.eafit.maestria.activa.container;

import org.osgi.framework.BundleContext;

import edu.eafit.maestria.activa.utilities.Activator;

public class ContainerActivator extends Activator {

	@Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        Container.init();
    }

}
