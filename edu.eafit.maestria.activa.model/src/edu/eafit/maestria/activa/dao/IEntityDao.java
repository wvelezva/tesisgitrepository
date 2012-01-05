package edu.eafit.maestria.activa.dao;

import edu.eafit.maestria.activa.model.IEntity;

public interface IEntityDao extends BasicDao<IEntity> {

	public IEntity newEntity();

}
