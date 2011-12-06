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
	
	public Map<String, String> getProperties();
	public void setProperties(Map<String, String> properties);
	
	public List<ITaggedResource> getTaggedResources();
	public void setTaggedResources(List<ITaggedResource> taggedResources);
}