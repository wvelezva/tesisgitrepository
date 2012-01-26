package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.Animation;
import edu.eafit.maestria.activa.model.IEntity;

public interface IEntityServices {
	
	public IEntity newEntity();
	public IEntity getById(long entityId);
	public void save(IEntity entity);
	public IEntity getByAnimation(Animation animation);
}
