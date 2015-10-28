package com.ecosystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name ="archetype")
public class Archetype {

	@Id
	@GeneratedValue
	@Column(name = "archetype_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}) 
	@JoinColumn(name="ecosystem_id", insertable = true, updatable = true, nullable = false)
	@JsonIgnore
	private Ecosystem ecosystem;
	
	
//	@OneToMany(mappedBy = "archetype", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
//	@OrderBy("sequenceOrder")
//	private List<ArchetypeField> archetypeFields; 
//	
//	
//	@OneToMany(mappedBy = "element", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
//	@OrderBy("sequenceOrder")
//	private List<Element> elements; 
	
	
	
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
	public Ecosystem getEcosystem() {
		return ecosystem;
	}
	public void setEcosystem(Ecosystem ecosystem) {
		this.ecosystem = ecosystem;
	}
	
	
}
