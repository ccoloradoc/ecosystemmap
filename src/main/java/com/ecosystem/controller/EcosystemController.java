package com.ecosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystem.model.Archetype;
import com.ecosystem.model.Ecosystem;
import com.ecosystem.model.User;
import com.ecosystem.service.EcosystemService;


@Controller
@RequestMapping("/portal")
public class EcosystemController {
	
	@Autowired
	private EcosystemService ecosystemService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
	   return "portal/home";
	}	
	
	@RequestMapping(value = "/ecosystem", method=RequestMethod.GET)
    @ResponseBody
    public List<Ecosystem> getEcosystems() {
		return ecosystemService.getEcosystemList();
    }
	
	@RequestMapping(value="/ecosystem", method=RequestMethod.POST)
    @ResponseBody
    public Ecosystem saveEcosystem(@RequestBody Ecosystem ecosystem) {
		ecosystemService.addEcosystem(ecosystem);
		return ecosystem;
	}
	
	@RequestMapping(value="/ecosystem", method=RequestMethod.PUT)
	@ResponseBody
	public List<Ecosystem> updateEcosystem(@RequestBody Ecosystem ecosystem) {
		ecosystemService.updateEcosystem(ecosystem);
		return ecosystemService.getEcosystemList();
	}
	
	@RequestMapping(value="/ecosystem/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public List<Ecosystem> deleteEcosystem(@PathVariable Integer id) {
		ecosystemService.removeEcosystem(id);
		return ecosystemService.getEcosystemList();
	}
	
	@RequestMapping(value = "/ecosystem/{id}/archetype", method=RequestMethod.GET)
    @ResponseBody
    public List<Archetype> getArchetypes(@PathVariable Integer id) {
		return ecosystemService.findArchetypesFor(id);
    }

}
