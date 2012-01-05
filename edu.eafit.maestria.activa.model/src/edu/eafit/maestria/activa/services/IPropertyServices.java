package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;


public interface IPropertyServices {
	
	public void delete(IProperty property);
	
	public IProperty newProperty(String key);

	public IProperty addProperty(String key, IEntity entity);
}
