package edu.eafit.maestria.activa.dao;

import java.io.File;

import edu.eafit.maestria.activa.model.IResource;

public interface IResourceDao extends BasicDao<IResource> {

	public IResource createResource(File file);


}
