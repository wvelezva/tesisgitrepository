package edu.eafit.maestria.activa.container;

import org.osgi.framework.BundleContext;
import org.picocontainer.Parameter;

import edu.eafit.maestria.activa.services.IMetadataServices;
import edu.eafit.maestria.activa.services.MetadataServicesImpl;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.utilities.Activator;

public class ContainerActivator extends Activator {

	@Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        start();
    }

	private void start(){
//		.addComponent(IProjectServices.class, ProjectServicesImpl.class, new Parameter[0]);
		Container.getInstance()
		.addComponent(IMetadataServices.class, MetadataServicesImpl.class, new Parameter[0])
		.addComponent(ProjectServicesImpl.getInstance());
	}
}
