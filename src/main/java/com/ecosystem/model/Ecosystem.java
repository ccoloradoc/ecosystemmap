package com.ecosystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name = "ecosystem")
public class Ecosystem {

	@Id
	@GeneratedValue
	@Column(name = "ecosystem_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	
	@OneToMany(mappedBy = "ecosystem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	@OrderBy("id")
	@JsonIgnore
	private List<Archetype> archetypes; 
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Archetype> getArchetypes() {
		return archetypes;
	}
	public void setArchetypes(List<Archetype> archetypes) {
		this.archetypes = archetypes;
	}
}
