package com.ecosystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ArchetypeField {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}) 
	@JoinColumn(name="id", insertable = true, updatable = true, nullable = false)
	@JsonIgnore
	private Archetype archetype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Archetype getArchetype() {
		return archetype;
	}

	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}
	
	
}
