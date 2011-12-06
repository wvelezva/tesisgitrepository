package edu.eafit.maestria.activa.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name="act_show")
@SequenceGenerator(name = SequenceName.SHOW_ID, sequenceName = SequenceName.SHOW_ID, allocationSize = 1)
public class Show implements IShow{
	private long showId;
	private String name;
	private List<IEntity> entities;
	
	@Id
	@GeneratedValue(generator = SequenceName.SHOW_ID, strategy = GenerationType.SEQUENCE)
	@Column(name="showid")
	public long getShowId() {
		return showId;
	}
	
	public void setShowId(long showId) {
		this.showId = showId;
	}
	
	@Column(nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(targetEntity=Entity.class)
	public List<IEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<IEntity> entities) {
		this.entities = entities;
	}
	
	
}
