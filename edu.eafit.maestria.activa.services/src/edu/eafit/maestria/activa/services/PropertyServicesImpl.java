package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.dao.IPropertyDao;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;

public class PropertyServicesImpl implements IPropertyServices {

	private IPropertyDao propertyDao;
	
	public PropertyServicesImpl(IPropertyDao propertyDao){
		this.propertyDao = propertyDao;
	}

	@Override
	public void delete(IProperty property) {
		propertyDao.delete(property);
	}

	@Override
	public IProperty newProperty(String key) {
		return propertyDao.newProperty(key);
	}

	@Override
	public IProperty addProperty(String key, IEntity entity) {
		return propertyDao.addProperty(key, entity);
	}
	
	
	
}
