package edu.eafit.maestria.activa.container;

import org.picocontainer.DefaultPicoContainer;

import edu.eafit.maestria.activa.dao.hibernate.EntityDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.PropertyDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.ResourceDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.TaggedResourceDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.TypeDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.utils.HibernateUtil;
import edu.eafit.maestria.activa.services.EntityServicesImpl;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.services.PropertyServicesImpl;
import edu.eafit.maestria.activa.services.ResourceServicesImpl;
import edu.eafit.maestria.activa.services.TypeServicesImpl;

public class Container extends DefaultPicoContainer{
	private static Container container = new Container();
	
	private Container(){
	}
	
	public static Container getInstance(){
		return container;
	}
	
	public static void init() {
	//		.addComponent(IProjectServices.class, ProjectServicesImpl.class, new Parameter[0]);
			//esta es otra forma de declarar un singleton en un enum,y funciona en el container
//			.addComponent(ProjectServicesEnum.INSTANCE);
			
		container.addComponent(HibernateUtil.getSession())
			.addComponent(TypeDaoImpl.class)
			.addComponent(EntityDaoImpl.class)
			.addComponent(PropertyDaoImpl.class)
			.addComponent(ResourceDaoImpl.class)
			.addComponent(TaggedResourceDaoImpl.class)
			.addComponent(TypeServicesImpl.class)
			.addComponent(EntityServicesImpl.class)
			.addComponent(PropertyServicesImpl.class)
			.addComponent(ResourceServicesImpl.class)
			.addComponent(ProjectServicesImpl.class);
	}
}
