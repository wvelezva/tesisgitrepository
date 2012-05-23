package edu.eafit.maestria.activa.services;
import java.io.File;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;


public interface IResourceServices {
	public void deleteTaggedResource(ITaggedResource taggedResource);
	public ITaggedResource addTaggedResource(String tag, IEntity entity, IResource resource);
	public IResource createResource(File file) throws Exception;
}
