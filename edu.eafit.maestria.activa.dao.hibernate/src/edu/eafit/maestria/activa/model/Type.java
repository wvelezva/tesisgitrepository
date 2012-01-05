package edu.eafit.maestria.activa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="act_type")
public class Type implements IType{
	private long type;
	private String label;
	
	@Id
	@GeneratedValue
	@Column(name="typeid")
	@Override
	public long getType() {
		return type;
	}

	@Override
	public void setType(long type) {
		this.type = type;
	}

	@Column(nullable=false)
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	

}
