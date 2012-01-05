package edu.eafit.maestria.activa.container;

import org.osgi.framework.BundleContext;

import edu.eafit.maestria.activa.dao.hibernate.EntityDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.TypeDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.utils.HibernateUtil;
import edu.eafit.maestria.activa.services.EntityServicesImpl;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.services.TypeServicesImpl;
import edu.eafit.maestria.activa.utilities.Activator;

public class ContainerActivator extends Activator {

	@Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        Container.init();
    }

}
