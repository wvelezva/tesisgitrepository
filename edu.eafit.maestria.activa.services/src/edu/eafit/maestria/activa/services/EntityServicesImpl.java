package edu.eafit.maestria.activa.services;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.eafit.maestria.activa.dao.IEntityDao;
import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;
import edu.eafit.maestria.activa.model.ITaggedResource;
import edu.eafit.maestria.activa.model.ResourceTag;

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
	public IEntity getById(long entityId){
		return entityDao.getById(entityId);
	}
	
	@Override
	public void save(IEntity entity) {
		if (entity == null || StringUtils.isBlank(entity.getName()) || entity.getType() == null)
			return;
		
		entityDao.save(entity);
	}

	@Override
	public IEntity getByAnimation(Animation animation) {
		IEntity entity = animation.getEntity();
		if (entity == null && animation.getEntityId() > 0) {
			entity = entityDao.getById(animation.getEntityId());
		} else if (entity == null){
			entity = entityDao.newEntity();
		}
		animation.setEntity(entity);
		return entity;
	}
	
	@Override
	public IResource getEntityImage(IEntity entity) {
		List<ITaggedResource> resources = entity.getTaggedResources();
		for (ITaggedResource taggedResource : resources){
			if (taggedResource.getTag() == ResourceTag.ENTITY) {
				return taggedResource.getResource();
			}
		}
		return null;
	}
	
	@Override
	public List<IEntity> getEntities(){
		return entityDao.getEntities();
	}

}
