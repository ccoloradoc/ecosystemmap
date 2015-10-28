package com.ecosystem.service;

import java.util.List;

import com.ecosystem.model.Ecosystem;

public interface EcosystemService {
	public void addEcosystem(Ecosystem ecosystem);
	
	public List<Ecosystem> getEcosystemList();
	
	public void removeEcosystem(Integer id);
	
	public void updateEcosystem(Ecosystem Ecosystem);
	
	public Ecosystem find(Integer EcosystemId);
}
