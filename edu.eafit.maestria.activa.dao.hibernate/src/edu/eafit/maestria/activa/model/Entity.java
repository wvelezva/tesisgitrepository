package edu.eafit.maestria.activa.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="act_entity")
public class Entity implements IEntity{
	private long entityId;
	private IType type;
	private String name;
	private String description;
	private Timestamp cdate;
	private Timestamp mdate;
	private boolean archived;
	private List<IProperty> properties = new ArrayList<IProperty>();
	private List<ITaggedResource> taggedResources  = new ArrayList<ITaggedResource>();
	
	@Override
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	
	@Id
	@GeneratedValue
	@Column(name="entityid")
	@Override
	public long getEntityId() {
		return entityId;
	}
	
	@ManyToOne(optional=false,targetEntity=Type.class)
	@JoinColumn(name="typeid")
	@Override
	public IType getType() {
		return type;
	}

	@Override
	public void setType(IType type) {
		this.type = type;
	}

	@Column(nullable=false)
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;	
	}
	
	/**
	 * @return the cdate
	 */
	@Column(name="cdate", nullable=false)
	public Timestamp getCdate()
	{
		return cdate;
	}

	/**
	 * @param cdate the cdate to set
	 */
	public void setCdate(Timestamp cdate)
	{
		this.cdate = cdate;
	}

	/**
	 * @return the mdate
	 */
	@Column(name="mdate", nullable=false)
	public Timestamp getMdate()
	{
		return mdate;
	}

	/**
	 * @param mdate the mdate to set
	 */
	public void setMdate(Timestamp mdate)
	{
		this.mdate = mdate;
	}
	
	
	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	@OneToMany(targetEntity=Property.class,mappedBy="entity",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@Override
	public List<IProperty> getProperties() {
		return properties;
	}
	@Override
	public void setProperties(List<IProperty> properties) {
		this.properties = properties;
	}
	
	@OneToMany(targetEntity=TaggedResource.class,mappedBy="entity",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	@Override
	public List<ITaggedResource> getTaggedResources() {
		return taggedResources;
	}
	@Override
	public void setTaggedResources(List<ITaggedResource> taggedResources) {
		this.taggedResources = taggedResources;
	}
}