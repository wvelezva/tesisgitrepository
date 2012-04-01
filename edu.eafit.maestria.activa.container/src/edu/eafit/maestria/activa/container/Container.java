package edu.eafit.maestria.activa.container;

import org.picocontainer.DefaultPicoContainer;

import edu.eafit.maestria.activa.dao.hibernate.EntityDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.PropertyDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.ResourceDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.TaggedResourceDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.TypeDaoImpl;
import edu.eafit.maestria.activa.dao.hibernate.utils.HibernateUtil;
import edu.eafit.maestria.activa.model.Project;
import edu.eafit.maestria.activa.services.EntityServicesImpl;
import edu.eafit.maestria.activa.services.ProjectServicesImpl;
import edu.eafit.maestria.activa.services.PropertyServicesImpl;
import edu.eafit.maestria.activa.services.ResourceServicesImpl;
import edu.eafit.maestria.activa.services.TypeServicesImpl;

public class Container extends DefaultPicoContainer{
	private static Container container = new Container();
	private static Project project;
	
	private Container(){
	}
	
//	public static Container getInstance(){
//		return container;
//	}
	
	public static void init() {
	//		.addComponent(IProjectServices.class, ProjectServicesImpl.class, new Parameter[0]);
			//esta es otra forma de declarar un singleton en un enum,y funciona en el container
//			.addComponent(ProjectServicesEnum.INSTANCE);
			
		//DAOs
		container.addComponent(HibernateUtil.getSession())
			.addComponent(EntityDaoImpl.class)
			.addComponent(PropertyDaoImpl.class)
			.addComponent(ResourceDaoImpl.class)
			.addComponent(TaggedResourceDaoImpl.class)
			.addComponent(TypeDaoImpl.class)
			;
			
		//Services
		container.addComponent(EntityServicesImpl.class)
			.addComponent(ProjectServicesImpl.class)
			.addComponent(PropertyServicesImpl.class)
			.addComponent(ResourceServicesImpl.class)
			.addComponent(TypeServicesImpl.class)
			;
		
	}
	
	public static void add(Object object){
		container.addComponent(object);
	}
	
	public static <T> T get(Class<T> componentType) {
		return container.getComponent(componentType);
	}
	
	public static Project getProject(){
		return project;
	}
	
	public static void setProject(Project project){
		Container.project = project;
	}
}
