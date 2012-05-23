package edu.eafit.maestria.activa.ui.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.IResourceTag;
import edu.eafit.maestria.activa.model.ITaggedResource;

public class TaggedResourceWrapper implements ITaggedResource {

	private static final String TAG = "tag";
	private static final String ENTITY = "entity";
	private static final String RESOURCE = "resource";
	private ITaggedResource wrappedTaggedResource;
	private EntityWrapper entityWrapper;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public TaggedResourceWrapper(ITaggedResource taggedResource, EntityWrapper entity){
		this.wrappedTaggedResource = taggedResource;
		this.entityWrapper = entity;
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	@Override
	public IResource getResource() {
		return wrappedTaggedResource.getResource();
	}

	@Override
	public void setResource(IResource resource) {
		propertyChangeSupport.firePropertyChange(RESOURCE, wrappedTaggedResource.getResource(), resource);
		wrappedTaggedResource.setResource(resource);

	}

	@Override
	public IEntity getEntity() {
		return wrappedTaggedResource.getEntity();
	}

	@Override
	public void setEntity(IEntity entity) {
		propertyChangeSupport.firePropertyChange(ENTITY, wrappedTaggedResource.getEntity(), entity);
		wrappedTaggedResource.setEntity(entity);
	}

	@Override
	public IResourceTag getTag() {
		return wrappedTaggedResource.getTag();
	}

	@Override
	public void setTag(IResourceTag tag) {
		propertyChangeSupport.firePropertyChange(TAG, wrappedTaggedResource.getTag(), tag);
		wrappedTaggedResource.setTag(tag);
	}

	public ITaggedResource getWrappedTaggedResource(){
		return wrappedTaggedResource;
	}
	
	public EntityWrapper getEntityWrapper(){
		return entityWrapper;
	}
}
