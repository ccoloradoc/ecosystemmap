package com.ecosystem.service;

import java.util.List;

import com.ecosystem.model.Archetype;
import com.ecosystem.model.Ecosystem;

public interface EcosystemService {
	public void addEcosystem(Ecosystem ecosystem);
	
	public List<Ecosystem> getEcosystemList();
	
	public void removeEcosystem(Integer id);
	
	public void updateEcosystem(Ecosystem ecosystem);
	
	public Ecosystem find(Integer ecosystemId);
	
	public List<Archetype> findArchetypesFor(Integer ecosystemId);
}
