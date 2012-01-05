package edu.eafit.maestria.activa.services;

import edu.eafit.maestria.activa.model.IEntity;

public interface IEntityServices {
	
	public IEntity newEntity();
	public void save(IEntity entity);
}
