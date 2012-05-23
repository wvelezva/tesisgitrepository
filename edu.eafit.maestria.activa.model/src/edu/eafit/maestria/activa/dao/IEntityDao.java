package edu.eafit.maestria.activa.dao;

import java.util.List;

import edu.eafit.maestria.activa.model.IEntity;

public interface IEntityDao extends BasicDao<IEntity> {

	public IEntity newEntity();
	public List<IEntity> getEntities();

}
