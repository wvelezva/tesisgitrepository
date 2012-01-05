package edu.eafit.maestria.activa.ui.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import edu.eafit.maestria.activa.model.IProperty;

public class PropertyWrapper implements IProperty{
	private IProperty wrappedProperty;
	private EntityWrapper entityWrapper;
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public PropertyWrapper(IProperty property, EntityWrapper entity) {
		this.wrappedProperty = property;
		this.entityWrapper = entity;
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	public String getKey() {
		return wrappedProperty.getKey();
	}
	public void setKey(String key) {
		propertyChangeSupport.firePropertyChange("key", wrappedProperty.getKey(), key);
		wrappedProperty.setKey(key);
	}
	public String getValue() {
		return wrappedProperty.getValue();
	}
	public void setValue(String value) {
		propertyChangeSupport.firePropertyChange("value", wrappedProperty.getValue(), value);
		wrappedProperty.setValue(value);
	}

	public IProperty getWrappedProperty() {
		return wrappedProperty;
	}
	
	public EntityWrapper getEntityWrapper(){
		return entityWrapper;
	}
}
