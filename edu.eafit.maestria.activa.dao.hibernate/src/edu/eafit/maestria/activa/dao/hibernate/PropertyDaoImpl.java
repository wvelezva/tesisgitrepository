package edu.eafit.maestria.activa.dao.hibernate;

import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.IPropertyDao;
import edu.eafit.maestria.activa.dao.hibernate.utils.BaseDaoHibernate;
import edu.eafit.maestria.activa.model.Entity;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IProperty;
import edu.eafit.maestria.activa.model.Property;

public class PropertyDaoImpl extends BaseDaoHibernate<IProperty> implements IPropertyDao {

	public PropertyDaoImpl(Session session) {
		super(session, Property.class);
	}

	@Override
	public IProperty newProperty(String key) {
		IProperty property = new Property();
		property.setKey(key);
		return property;
	}

	@Override
	public IProperty addProperty(String key, IEntity entity) {
		Property property = new Property();
		property.setKey(key);
		property.setValue("");
		property.setEntity(entity);
		
		Entity entityImpl = (Entity) entity;
		entityImpl.getProperties().add(property);
		return property;
	}
}
