package edu.eafit.maestria.activa.dao.hibernate;

import java.io.File;

import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.IResourceDao;
import edu.eafit.maestria.activa.dao.hibernate.utils.BaseDaoHibernate;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.Resource;
import edu.eafit.maestria.activa.services.IResourceServices;

public class ResourceDaoImpl extends BaseDaoHibernate<IResource> implements IResourceDao {

	public ResourceDaoImpl(Session session) {
		super(session, Resource.class);
	}

	@Override
	public IResource createResource(File file) {
		Resource resource = new Resource();
		resource.setName(file.getName());
		save(resource);
		return resource;
	}
	
}
