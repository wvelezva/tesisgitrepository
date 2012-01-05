package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.dao.IEntityDao;
import edu.eafit.maestria.activa.model.IEntity;

public class EntityServicesImpl implements IEntityServices {

	private IEntityDao entityDao;
	
	public EntityServicesImpl(IEntityDao entityDao){
		this.entityDao = entityDao;
	}
	
	@Override
	public IEntity newEntity() {
		return entityDao.newEntity();
	}

	@Override
	public void save(IEntity entity) {
		entityDao.save(entity);
	}

}
