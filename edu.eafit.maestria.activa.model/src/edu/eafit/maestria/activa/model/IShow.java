package edu.eafit.maestria.activa.model;
import java.util.List;


public interface IShow {
	public long getShowId();
	public void setShowId(long showId);
	
	public String getName();
	public void setName(String name);
	
	public List<IEntity> getEntities();
	public void setEntities(List<IEntity> entities);
}
