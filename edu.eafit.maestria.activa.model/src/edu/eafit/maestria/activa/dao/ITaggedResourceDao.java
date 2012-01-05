package edu.eafit.maestria.activa.dao;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.IResourceTag;
import edu.eafit.maestria.activa.model.ITaggedResource;

public interface ITaggedResourceDao extends BasicDao<ITaggedResource> {

	public ITaggedResource addTaggedResource(String tag, IEntity entity, IResource resource);

}
