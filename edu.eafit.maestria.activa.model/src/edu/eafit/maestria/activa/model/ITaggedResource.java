package edu.eafit.maestria.activa.model;

public interface ITaggedResource {
	public IResource getResource();
	public void setResource(IResource resource);
	public IEntity getEntity();
	public void setEntity(IEntity entity);
	public IResourceTag getTag();
	public void setTag(IResourceTag tag);
}
