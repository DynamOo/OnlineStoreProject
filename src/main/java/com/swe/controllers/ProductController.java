package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swe.entities.NormalUser;
import com.swe.entities.Product;
import com.swe.repositories.BrandRepository;
import com.swe.repositories.NormalUserRepository;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.StoreOwnerRepository;
import com.swe.repositories.StoreRepository;
import com.swe.repositories.UserRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired 
	private NormalUserRepository normalUserRepo;
	
	@Autowired 
	private StoreOwnerRepository ownerRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@GetMapping("/aHome/seeSuggestedProducts")
    public String showSuggestedProducts(Model model) {
    	
    	Iterable<Product> productsIterable = productRepo.findAll();
    	List<Product> suggestedProductsList = new ArrayList<Product>();
    	
    	for (Product product : productsIterable) {
    		if (product.isConfirmed() == false)
    			suggestedProductsList.add(product);
    	}
    	
    	model.addAttribute("suggestedProducts", suggestedProductsList);
    	return "seeSuggestedProducts";
    	
    }
	
	@GetMapping("/nHome/seeSystemProducts/{user_id}")
    public String showSystemProducts(@PathVariable int user_id, Model model) {
    	
    	Iterable<Product> productsIterable = productRepo.findAll();
    	List<Product> systemProductsList = new ArrayList<Product>();
    	
    	for (Product product : productsIterable) {
    		if (product.isConfirmed() == true)
    			systemProductsList.add(product);
    	}
    	
    	model.addAttribute("systemProducts", systemProductsList);
    	model.addAttribute("GlobalID", user_id); // YEEEESSSSSSSSS 3shan ageb el-id bta3 el-user elly hyshtry
    	
    	return "seeSystemProducts";
    	
    }
	
	@RequestMapping("/showProductDetails/{user_id}/{productId}")
	public String ShowProductDetails(@PathVariable int user_id, @PathVariable int productId, Model model) 
	{
		Product product = productRepo.findOne(productId);
		int oldViews = product.getNumOfViews();
		product.setNumOfViews(++oldViews);
		productRepo.save(product);
		
		String userType = userRepo.findOne(user_id).getType();
		if (userType.equals("owner")) {
			//TODO: I'm first trying with a normal user, then if everything is okay, I will handle store owner
		}
		else {
			NormalUser user = normalUserRepo.findOne(user_id);
			int oldProductsViews = user.getNumberOfProductsViewed();
			user.setNumberOfProductsViewed(++oldProductsViews);
			normalUserRepo.save(user);
			model.addAttribute("currentUser", user);
		}
		
		String brandName = brandRepo.findOne(product.getBrandID()).getBrandName();
		String storeName = storeRepo.findOne(product.getStoreID()).getStoreName();
		String ownerName = ownerRepo.findOne(product.getOwnerID()).getFirstName() + " " + ownerRepo.findOne(product.getOwnerID()).getLastName();
		
		model.addAttribute("brandName", brandName);
		model.addAttribute("storeName", storeName);
		model.addAttribute("ownerName", ownerName);
		model.addAttribute("currentProduct", product);
		model.addAttribute("userID", user_id);
		
		return "showProductDetails";
	}
	
//	@RequestMapping(value="/nHome/showTheBill/${userId}/${productId}", method = RequestMethod.GET)
	@RequestMapping("/nHome/showTheBill/{userId}/{productId}")
	public String showTheBill(@PathVariable int userId, @PathVariable int productId, @RequestParam String desiredQuantity, @RequestParam String desiredAddress,
			 Model model)
	{
		Product product = productRepo.findOne(productId);
		NormalUser user = normalUserRepo.findOne(userId);
		
		double originalPrice = product.getPrice();
		double sellingPrice = originalPrice;
		int desiredAmount = Integer.valueOf(desiredQuantity);
		
		if (!user.hasBoughtBefore())
		{
			sellingPrice -= (originalPrice * 5/100);
			
			if (desiredAmount > 2)
				sellingPrice -= (originalPrice * 15/100); // new -> 5 ... +2 -> 10 ... total 15
		}
			
		model.addAttribute("currentProduct", product); // To get productName and productID from it
		model.addAttribute("desiredAmount", desiredAmount);
		model.addAttribute("sellingPrice", sellingPrice);
		model.addAttribute("desiredAddress", desiredAddress);
		model.addAttribute("userID", userId);
		
		return "showTheBill";  
    }
	
	@RequestMapping("/nHome/confirmTransaction/{userId}/{productId}/{soldQuantity}")
	public String confirmTransaction(@PathVariable int userId, @PathVariable int productId, @PathVariable int soldQuantity)
	{
		Product product = productRepo.findOne(productId);
		NormalUser user = normalUserRepo.findOne(userId);
		
		int oldQuantity = product.getQuantity();
		product.setQuantity(oldQuantity - soldQuantity);
		user.setBoughtBefore(true);
		
		productRepo.save(product);
		normalUserRepo.save(user);
		
//		return "nHome";  
		return "redirect:/nHome";
    }
	
}
