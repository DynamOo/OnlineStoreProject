package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.swe.entities.Brand;
import com.swe.entities.Product;
import com.swe.entities.Store;
import com.swe.repositories.BrandRepository;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.StoreRepository;

@Controller
@SessionAttributes("GlobalID")
public class StoreOwnerController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
//	//@GetMapping("/oHome?id={someNum}/suggestStore")
	@GetMapping("/oHome/suggestStore")
	public String getStoreSuggestionForm(Model model) {
		model.addAttribute("Store", new Store());
		return "suggestStore"; // b3ml redirect fe el-POST bs msh 3arf leh bs mstrya7 keda :D         					
    }
	
	@PostMapping("/oHome/suggestStore")
	public String suggestStore(Model model, @ModelAttribute Store store) {
    	System.out.println(store.getStoreName());
    	System.out.println(store.getLocation());
    	System.out.println(store.getOwnerID());  // w el-tany el-mafrood yb2a fe 7dod el-database bs hnak (owner_fk)
    	storeRepo.save(store);
		return "redirect:/oHome";
	}
	
	@GetMapping("/oHome/suggestProduct")
	public String getProductSuggestionForm(Model model) {
		model.addAttribute("Product", new Product());
		
		// ------------------ NEWLY ADDED 1 ------------------
		Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> systemStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (store.isConfirmed() == true)
    			systemStoresList.add(store);
    	}
    	model.addAttribute("systemStoresList", systemStoresList);
		// ------------------      END      ------------------
    	
    	// ------------------ NEWLY ADDED 2 ------------------
		Iterable<Brand> brandsIterable = brandRepo.findAll();
		List<Brand> systemBrandsList = new ArrayList<Brand>();

		for (Brand brand : brandsIterable) {
			systemBrandsList.add(brand);
		}
		model.addAttribute("systemBrandsList", systemBrandsList);
		// ------------------      END      ------------------
    	    	
		return "suggestProduct";        					
    }
	
	@PostMapping("/oHome/suggestProduct")
	public String suggestProduct(Model model, @ModelAttribute Product product) {
		
    	System.out.println(product.getProductName());
    	System.out.println(product.getOwnerID()); 
    	productRepo.save(product);
		return "redirect:/oHome";
	}
	
}
