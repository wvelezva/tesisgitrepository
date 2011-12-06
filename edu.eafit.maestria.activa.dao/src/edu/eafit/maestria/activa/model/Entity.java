package edu.eafit.maestria.activa.model;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="act_entity")
@SequenceGenerator(name = SequenceName.ENTITY_ID, sequenceName = SequenceName.ENTITY_ID, allocationSize = 1)
public class Entity implements IEntity{
	private long entityId;
	private IType type;
	private String name;
	private String description;
	private Timestamp cdate;
	private Timestamp mdate;
	private boolean archived;
	private Map<String, String> properties;
	private List<ITaggedResource> taggedResources;
	
	@Override
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	
	@Id
	@GeneratedValue(generator = SequenceName.ENTITY_ID, strategy = GenerationType.SEQUENCE)
	@Column(name="entityid")
	@Override
	public long getEntityId() {
		return entityId;
	}
	
	@ManyToOne(optional=false,targetEntity=EntityType.class)
	@JoinColumn(name="entitytypeid")
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

	@ElementCollection()
	@JoinTable(name = "act_property", joinColumns = @JoinColumn(name="entityid"))
	@Override
	public Map<String, String> getProperties() {
		return properties;
	}
	@Override
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}
	
	@OneToMany(mappedBy="entity",targetEntity=TaggedResource.class,fetch=FetchType.LAZY)
	public List<ITaggedResource> getTaggedResources() {
		return taggedResources;
	}
	@Override
	public void setTaggedResources(List<ITaggedResource> taggedResources) {
		this.taggedResources = taggedResources;
	}
}