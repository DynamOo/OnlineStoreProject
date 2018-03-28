package com.swe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.swe.entities.Store;
import com.swe.repositories.StoreRepository;

@Controller
@SessionAttributes("GlobalID")
public class StoreOwnerController {
	
//	@GetMapping("/printGlobalID")
//	public void printGlobalIDAbosEdak(@SessionAttribute("GlobalID") int ownerID) {
//		
//		System.out.println("Global ID's value is: " + ownerID);         					
//    }
	
//	@Autowired
//	private StoreRepository storeRepo;
//	
//	//@GetMapping("/oHome?id={someNum}/suggestStore")
//	@GetMapping("/oHome/suggestStore")
//	public String getSuggestionForm(Model model) {
//		model.addAttribute("Store", new Store());
//		return "suggestStore";          					
//    }
//	
//	//@PostMapping("/oHome?id={someNum}/suggestStore")
//	@PostMapping("/oHome/suggestStore")
////    public String suggestStore(Model model, @ModelAttribute Store store, @SessionAttribute("GlobalID") int ownerID) {
//	public String suggestStore(Model model, @ModelAttribute Store store, @ModelAttribute("GlobalID") int ownerID) {
//		
//    	System.out.println(store.getStoreName());
//    	System.out.println(store.getLocation());
//    	
//    	int storeID = store.getStoreID();
//    	String storeName = store.getStoreName();
//    	String location = store.getLocation();
//    	String storeType = store.getStoreType();
//    	
//    	//StoreOwner owner = getStoreOwnerInSession();
//    	model.addAttribute("store", new Store(ownerID, storeID, storeName, location, storeType));
//    	
//    	storeRepo.save(store);
//    	
//    	String redirectPage = "redirect:/oHome"; 
//    	return redirectPage;                 		// b3ml redirect 3la tol mn 3'er m-handlha fe html page
//    }
	
}
