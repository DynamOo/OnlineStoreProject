package com.swe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swe.entities.Action;
import com.swe.entities.Product;
import com.swe.entities.TempProduct;
import com.swe.repositories.ActionRepository;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.TempProductRepository;

@Controller
public class ActionController {
	
	@Autowired
	private ActionRepository actionRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private TempProductRepository tempProductRepo;
	
	@GetMapping("/oHome/seeActions/{user_id}/{store_id}")
	private String getActions(@PathVariable int user_id, @PathVariable int store_id, Model model)
	{
		List<Action> storeActions = actionRepo.findByStoreID(store_id);
		model.addAttribute("storeActions", storeActions);
		model.addAttribute("user_id", user_id);
		return "seeActions";
	}
	
	@GetMapping("/oHome/acceptAction/{user_id}/{actionId}")
	private String acceptAction(@PathVariable int actionId)
	{
		Action action = actionRepo.findOne(actionId);
		action.setAccepted(true);
		actionRepo.save(action);
		return "seeActions";
	}
	
	@GetMapping("/oHome/undoAction/{user_id}/{actionId}")
	private String undoAction(@PathVariable int actionId)
	{
		Action action = actionRepo.findOne(actionId);
		String type = action.getActionType();
		int productID = action.getProductID();
		
		if (type.equals("add"))
		{
			Product product = productRepo.findOne(productID);
			productRepo.delete(product);
		}
		else if (type.equals("edit"))
		{
			Product newProduct = productRepo.findOne(productID);
			productRepo.delete(newProduct);
			
			TempProduct product = tempProductRepo.findOneByProductIDAndActionType(productID, "edit"); // hdeef flag msln "got from delete aw got from edit"
			
			int productId = product.getProductID();
			String productName = product.getProductName(), 
					category = product.getCategory(), 
					productType = product.getProductType();
			int price = product.getPrice(), 
					quantity = product.getQuantity(), 
					numOfViews = product.getNumOfViews(), 
					ownerID = product.getOwnerID(), 
					brandID = product.getBrandID(), 
					storeID = product.getStoreID(),
					numberOfTimesSold = product.getNumberOfTimesSold();
			boolean confirmed = product.isConfirmed();
			
			Product returnedProduct = new Product(productId, productName, category, productType, price, quantity, numOfViews, ownerID, brandID, storeID, confirmed, numberOfTimesSold);
			productRepo.save(returnedProduct);
		}
		else if (type.equals("delete"))
		{
			TempProduct product = tempProductRepo.findOneByProductIDAndActionType(productID, "delete"); // hdeef flag msln "got from delete aw got from edit"
			
			int productId = product.getProductID();
			String productName = product.getProductName(), 
					category = product.getCategory(), 
					productType = product.getProductType();
			int price = product.getPrice(), 
					quantity = product.getQuantity(), 
					numOfViews = product.getNumOfViews(), 
					ownerID = product.getOwnerID(), 
					brandID = product.getBrandID(), 
					storeID = product.getStoreID(),
					numberOfTimesSold = product.getNumberOfTimesSold();
			boolean confirmed = product.isConfirmed();
			
			Product returnedProduct = new Product(productId, productName, category, productType, price, quantity, numOfViews, ownerID, brandID, storeID, confirmed, numberOfTimesSold);
			productRepo.save(returnedProduct);
		}
		
		actionRepo.delete(action);
		return "seeActions";
	}
	
}
