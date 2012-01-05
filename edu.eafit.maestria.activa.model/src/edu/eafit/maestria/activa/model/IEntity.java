package edu.eafit.maestria.activa.model;


import java.util.List;
import java.util.Map;

public interface IEntity {
	
	public void setEntityId(long entityId);
	public long getEntityId();
	
	public void setType(IType type);
	public IType getType();
	
	public String getName();
	public void setName(String name);
	
	public String getDescription();
	public void setDescription(String description);
	
	public List<IProperty> getProperties();
	public void setProperties(List<IProperty> properties);
	
	public List<ITaggedResource> getTaggedResources();
	public void setTaggedResources(List<ITaggedResource> taggedResources);
}