package com.swe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swe.entities.Brand;
import com.swe.entities.Product;
import com.swe.entities.Store;
import com.swe.repositories.BrandRepository;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.StoreRepository;

@Controller
public class AdminController {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
//	@RequestMapping(value="/processForm",params="accept",method=RequestMethod.POST)	
	@RequestMapping("/acceptStore/{storeId}")
	public String acceptStore(@PathVariable int storeId){
		System.out.println(storeId);                      // For Debugging
		Store store = storeRepo.findOne(storeId);
		System.out.println(store.getStoreName());         // For Debugging
		store.setConfirmed(true);
		storeRepo.save(store);
		return "redirect:/aHome/seeSuggestedStores";
	}
	
	@GetMapping("/aHome/addBrand")
	public String getAddBrandForm(Model model) {
		model.addAttribute("Brand", new Brand());
		return "addBrand";    					
    }
	
	@PostMapping("/aHome/addBrand")
	public String addBrand(Model model, @ModelAttribute Brand brand) {
    	System.out.println(brand.getBrandName());
    	brandRepo.save(brand);
		return "redirect:/aHome";
	}
	
	@RequestMapping("/acceptProduct/{productId}")
	public String acceptProduct(@PathVariable int productId) {
		System.out.println(productId);                        // For Debugging
		Product product = productRepo.findOne(productId);
		System.out.println(product.getProductName());         // For Debugging
		product.setConfirmed(true);
		productRepo.save(product);
		return "redirect:/aHome/seeSuggestedProducts";
	}
	
//	@RequestMapping("/acceptBrand/{brandId}")
//	public String acceptBrand(@PathVariable int brandId) {
//		System.out.println(brandId);                      // For Debugging
//		Brand brand = brandRepo.findOne(brandId);
//		System.out.println(brand.getBrandName());         // For Debugging
//		brand.setConfirmed(true);
//		brandRepo.save(brand);
//		return "redirect:/aHome/seeSuggestedBrands";
//	}

	
}
