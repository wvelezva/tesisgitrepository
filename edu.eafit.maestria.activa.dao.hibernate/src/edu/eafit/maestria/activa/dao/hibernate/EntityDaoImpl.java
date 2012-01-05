package edu.eafit.maestria.activa.dao.hibernate;

import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.IEntityDao;
import edu.eafit.maestria.activa.dao.hibernate.utils.BaseDaoHibernate;
import edu.eafit.maestria.activa.model.Entity;
import edu.eafit.maestria.activa.model.IEntity;

public class EntityDaoImpl extends BaseDaoHibernate<IEntity> implements IEntityDao {

	public EntityDaoImpl(Session session) {
		super(session, Entity.class);
	}
	
	@Override
	public IEntity newEntity(){
		IEntity entity = new Entity();
		return entity;
	}
}
