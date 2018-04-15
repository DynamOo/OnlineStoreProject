package com.swe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.swe.entities.Collaborator;
import com.swe.repositories.CollaboratorRepository;

@Controller
public class CollaboratorController {
	
	@Autowired
	private CollaboratorRepository collaboratorRepo;
	
	@GetMapping("/oHome/addCollaborator/{user_id}/{store_id}")
	public String getAddCollaboratorForm(@PathVariable int user_id, @PathVariable int store_id, Model model)
	{
		model.addAttribute("newCollaborator", new Collaborator());
//		model.addAttribute("user_id", user_id);
		model.addAttribute("store_id", store_id);
		return "addCollaborator";          					
    }
	
	@PostMapping("/addCollaborator/{storeId}")
    public String addCollaborator(Model model, @ModelAttribute Collaborator newCollaborator, @PathVariable int storeId)
	{	
		newCollaborator.setType("collaborator");
		newCollaborator.addStore(storeId);
		collaboratorRepo.save(newCollaborator);
		return "redirect:/oHome";
	}	
}



