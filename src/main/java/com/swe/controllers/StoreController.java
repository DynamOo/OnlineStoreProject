package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.swe.entities.Store;
import com.swe.repositories.StoreRepository;

@Controller
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@GetMapping("/oHome/showMyStores")
    public String showStoresForSomeOwner(Model model) {
    	
    	Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> storesList = new ArrayList<Store>();
    	
    	// w b3den hmla b2a el-stores list FROM stores iterable
    	for (Store store : storesIterable) {
    		if (store.getOwnerID() == 2)	
    			storesList.add(store);
    	}
    	
    	model.addAttribute("myStores", storesList);
    	return "showMyStores";
    	
    }
	
	@GetMapping("/aHome/seeSuggestedStores")
    public String showSuggestedStores(Model model) {
    	
    	Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> suggestedStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (store.isConfirmed() == false)
    			suggestedStoresList.add(store);
    	}
    	
    	model.addAttribute("suggestedStores", suggestedStoresList);
    	return "seeSuggestedStores";
    	
    }
	
	public List<Store> getConfirmedStores() {
		
		Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> systemStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (store.isConfirmed() == true)
    			systemStoresList.add(store);
    	}
    	
    	return systemStoresList;
    	
	}
	
}
