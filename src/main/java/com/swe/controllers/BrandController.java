package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.swe.entities.Brand;
import com.swe.repositories.BrandRepository;

@Controller
public class BrandController {
	
	@Autowired
	private BrandRepository brandRepo;
	
	@GetMapping("/aHome/seeSystemBrands")
    public String showSuggestedStores(Model model) {
    	
    	Iterable<Brand> brandsIterable = brandRepo.findAll();
    	List<Brand> brandsList = new ArrayList<Brand>();
    	
    	for (Brand brand : brandsIterable) {
    		if (brand.isConfirmed() == false)
    			brandsList.add(brand);
    	}
    	
    	model.addAttribute("systemBrands", brandsList);
    	return "seeSystemBrands";
    	
    }
	
}
