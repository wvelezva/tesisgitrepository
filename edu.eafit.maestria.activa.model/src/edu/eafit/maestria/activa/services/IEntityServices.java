package edu.eafit.maestria.activa.services;

import java.util.List;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;
import edu.eafit.maestria.activa.model.IResource;

public interface IEntityServices {
	
	public IEntity newEntity();
	public IEntity getById(long entityId);
	public void save(IEntity entity);
	public IEntity getByAnimation(Animation animation);
	public IResource getEntityImage(IEntity entity);
	public List<IEntity> getEntities();
}
