package edu.eafit.maestria.activa.dao;

import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;

public interface IPropertyDao extends BasicDao<IProperty> {

	public IProperty newProperty(String key);

	public IProperty addProperty(String key, IEntity entity);

}
