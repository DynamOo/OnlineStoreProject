package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swe.entities.Product;
import com.swe.entities.Store;
import com.swe.entities.StoreOwner;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.StoreOwnerRepository;
import com.swe.repositories.StoreRepository;

@Controller
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private StoreOwnerRepository ownerRepo;
	
	@GetMapping("/oHome/showMyStores/{user_id}")
    public String showStoresForSomeOwner(@PathVariable int user_id, Model model) {
    	
    	Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> storesList = new ArrayList<Store>();
    	
    	// w b3den hmla b2a el-stores list FROM stores iterable
    	for (Store store : storesIterable) {
    		if (store.getOwnerID() == user_id)	
    			storesList.add(store);
    	}
    	
    	model.addAttribute("myStores", storesList);
    	return "showMyStores";
    	
    }
	
	// TODO: Testing show my stores, b-shart en afltar mn el-stores elly 3nd el-owner da
	@GetMapping("/oHome/showMyStoresTEST/{user_id}")
    public String showStoresForSomeOwnerTEST(@PathVariable int user_id, Model model) {
    	
		StoreOwner currentOwner = ownerRepo.findOne(user_id);
		List<Integer> ownerStores = currentOwner.getStores();
    	Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> storesList = new ArrayList<Store>();
    	
    	// w b3den hmla b2a el-stores list FROM stores iterable
    	for (Store store : storesIterable) {
    		if (ownerStores.contains(store.getStoreID()))	
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
	
	public List<Store> getConfirmedStores()      // I wasn't aware of the idea of custom queries that return lists
	{	
		Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> systemStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (store.isConfirmed() == true)
    			systemStoresList.add(store);
    	}
    	
    	return systemStoresList; 	
	}
	
	@GetMapping("/oHome/seeStatistics/{user_id}/{store_id}")
	public String seeStatistics(@PathVariable int user_id, @PathVariable int store_id, Model model)
	{	
		int numOfViews = productRepo.getTotalNumberOfViews(store_id);
		int numOfPurchases = productRepo.getTotalNumberOfPurchases(store_id);
		List<Product> soldOutProducts = productRepo.findByQuantityAndStoreID(0, store_id);
		List<Product> availableProducts = productRepo.findByStoreIDOrderByNumberOfTimesSoldDesc(store_id);
		
		model.addAttribute("numOfViews", numOfViews);
		model.addAttribute("numOfPurchases", numOfPurchases);
		model.addAttribute("soldOutProducts", soldOutProducts);
		model.addAttribute("availableProducts", availableProducts);
		
		return "seeStatistics";
	}
	
}












