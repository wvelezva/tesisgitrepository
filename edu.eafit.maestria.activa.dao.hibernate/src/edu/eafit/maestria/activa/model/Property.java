package edu.eafit.maestria.activa.model;


import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="act_property")
public class Property implements IProperty{
	private long propertyId;
	private IEntity entity;
	private String key;
	private String value;
	
	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}
	
	@Id
	@GeneratedValue
	@Column(name="propertyid")
	public long getPropertyId() {
		return propertyId;
	}
	
	@ManyToOne(optional=false,targetEntity=Entity.class,fetch=FetchType.EAGER)
	@JoinColumn(name="entityid")
	public IEntity getEntity() {
		return entity;
	}

	public void setEntity(IEntity entity) {
		this.entity = entity;
	}

	
	@Column(nullable=false)
	@Override
	public String getKey() {
		return key;
	}
	@Override
	public void setKey(String key) {
		this.key = key;
	}
	
	@Column(nullable=false)
	@Override
	public String getValue() {
		return value;
	}
	@Override
	public void setValue(String value) {
		this.value = value;	
	}
}