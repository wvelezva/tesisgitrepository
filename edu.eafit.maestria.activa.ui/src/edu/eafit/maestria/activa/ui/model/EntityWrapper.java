package edu.eafit.maestria.activa.ui.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import edu.eafit.maestria.activa.container.Container;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.IType;
import edu.eafit.maestria.activa.services.IPropertyServices;
import edu.eafit.maestria.activa.services.IResourceServices;

public class EntityWrapper implements IEntity {

	private IEntity entity;
	private List<IProperty> propertiesWrapped;
	private List<ITaggedResource> taggedResourcesWrapped;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public EntityWrapper(IEntity entity){
		this.entity = entity;
		propertiesWrapped = new ArrayList<IProperty>();
		for (IProperty property : entity.getProperties()) {
			propertiesWrapped.add(new PropertyWrapper(property, this));
		}
		propertiesWrapped.add(new PropertyWrapper(new PropertyHelper(), this));

		taggedResourcesWrapped = new ArrayList<ITaggedResource>();
		for (ITaggedResource taggedResource : entity.getTaggedResources()) {
			taggedResourcesWrapped.add(new TaggedResourceWrapper(taggedResource, this));
		}
		taggedResourcesWrapped.add(new TaggedResourceWrapper(new TaggedResourceHelper(), this));
	}

	public IEntity getWrappedEntity(){
		return entity;
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	@Override
	public void setEntityId(long entityId) {
		propertyChangeSupport.firePropertyChange("entityId", this.entity.getEntityId(),	entityId);
		this.entity.setEntityId(entityId);
	}

	@Override
	public long getEntityId() {
		return entity.getEntityId();
	}

	@Override
	public void setType(IType type) {
		propertyChangeSupport.firePropertyChange("type", this.entity.getType(),	type);
		this.entity.setType(type);
	}

	@Override
	public IType getType() {
		return entity.getType();
	}

	@Override
	public String getName() {
		return entity.getName();
	}

	@Override
	public void setName(String name) {
		propertyChangeSupport.firePropertyChange("name", this.entity.getName(),	name);
		this.entity.setName(name);
	}

	@Override
	public String getDescription() {
		return entity.getDescription();
	}

	@Override
	public void setDescription(String description) {
		propertyChangeSupport.firePropertyChange("description", this.entity.getDescription(), description);
		this.entity.setDescription(description);
	}

	@Override
	public List<IProperty> getProperties() {
		return propertiesWrapped;
	}
	
	@Override
	public void setProperties(List<IProperty> properties) {
		propertyChangeSupport.firePropertyChange("properties", this.entity.getProperties(),	properties);
		this.entity.setProperties(properties);

	}

	@Override
	public List<ITaggedResource> getTaggedResources() {
		return taggedResourcesWrapped;
	}

	@Override
	public void setTaggedResources(List<ITaggedResource> taggedResources) {
		propertyChangeSupport.firePropertyChange("taggedResources", this.entity.getTaggedResources(), taggedResources);
		this.entity.setTaggedResources(taggedResources);
	}

	public void removeProperty(PropertyWrapper property) {
		propertiesWrapped.remove(property);
		this.entity.getProperties().remove(property.getWrappedProperty());
		IPropertyServices propertyServices = (IPropertyServices)Container.get(IPropertyServices.class);
		propertyServices.delete(property.getWrappedProperty());
	}
	
	public void removeTaggedResource(TaggedResourceWrapper taggedResource) {
		taggedResourcesWrapped.remove(taggedResource);
		this.entity.getTaggedResources().remove(taggedResource.getWrappedTaggedResource());
		IResourceServices resourceServices = (IResourceServices)Container.get(IResourceServices.class);
		resourceServices.deleteTaggedResource(taggedResource.getWrappedTaggedResource());
	}


}
