package com.ecosystem.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystem.model.Archetype;
import com.ecosystem.model.Ecosystem;
import com.ecosystem.service.EcosystemService;

@Service
public class EcosystemServiceImpl implements EcosystemService {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void addEcosystem(Ecosystem ecosystem) {
		em.persist(ecosystem);
	}
	
	@Transactional
	public List<Ecosystem> getEcosystemList() {
		CriteriaQuery<Ecosystem> u = em.getCriteriaBuilder().createQuery(Ecosystem.class);
		u.from(Ecosystem.class);
		return em.createQuery(u).getResultList();
	}
	
	@Transactional
	public void removeEcosystem(Integer id) {
		Ecosystem u = em.find(Ecosystem.class, id);
		if( null != u)
			em.remove(u);
	}
	
	@Transactional
	public void updateEcosystem(Ecosystem ecosystem) {
		em.merge(ecosystem);
	}
	
	@Transactional
	public Ecosystem find(Integer ecosystemId) {
		return em.find(Ecosystem.class, ecosystemId);
	}

	@Transactional
	public List<Archetype> findArchetypesFor(Integer ecosystemId) {
		Ecosystem ecosystem = em.find(Ecosystem.class, ecosystemId);
		if(ecosystem != null)
			return ecosystem.getArchetypes();
		return null;
	}

}
