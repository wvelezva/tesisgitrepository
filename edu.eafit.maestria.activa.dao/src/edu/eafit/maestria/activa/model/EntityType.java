package edu.eafit.maestria.activa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="act_entity_type")
@SequenceGenerator(name = SequenceName.ENTITY_TYPE_ID, sequenceName = SequenceName.ENTITY_TYPE_ID, allocationSize = 1)
public class EntityType implements IType{
	private long type;
	private String label;
	
	@Id
	@GeneratedValue(generator = SequenceName.ENTITY_TYPE_ID, strategy = GenerationType.SEQUENCE)
	@Column(name="entitytypeid")
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
