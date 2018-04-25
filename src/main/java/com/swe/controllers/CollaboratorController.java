package com.swe.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swe.entities.Action;
import com.swe.entities.Brand;
import com.swe.entities.Collaborator;
import com.swe.entities.Product;
import com.swe.entities.Store;
import com.swe.entities.TempProduct;
import com.swe.repositories.ActionRepository;
import com.swe.repositories.BrandRepository;
import com.swe.repositories.CollaboratorRepository;
import com.swe.repositories.ProductRepository;
import com.swe.repositories.StoreRepository;
import com.swe.repositories.TempProductRepository;

@Controller
public class CollaboratorController {
	
	@Autowired
	private CollaboratorRepository collaboratorRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private BrandRepository brandRepo;
	
	@Autowired
	private ActionRepository actionRepo;
	
	@Autowired
	private TempProductRepository tempProductRepo;
	
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
	
	@GetMapping("/cHome/showCollaboratorStores/{user_id}")
	private String showCollaboratorStores(@PathVariable int user_id, Model model)
	{
		Collaborator currentCollaborator = collaboratorRepo.findOne(user_id);
		List<Integer> collaboratorStores = currentCollaborator.getStores();
		
		Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> collaboratorStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (collaboratorStores.contains(store.getStoreID()))
    			collaboratorStoresList.add(store);
    	}
    	
    	model.addAttribute("collaboratorStores", collaboratorStoresList);
		return "showCollaboratorStores";
	}
	
	@GetMapping("cHome/collaboratorSuggestProduct/{user_id}")	
	public String getProductSuggestionForm(@PathVariable int user_id, Model model)
	{
		model.addAttribute("Product", new Product());
		model.addAttribute("user_id", user_id);
		
		// ------------------ To Get Collaborator Stores ------------------
		Collaborator currentCollaborator = collaboratorRepo.findOne(user_id);
		List<Integer> collaboratorStores = currentCollaborator.getStores();

		Iterable<Store> storesIterable = storeRepo.findAll();
    	List<Store> collaboratorStoresList = new ArrayList<Store>();
    	
    	for (Store store : storesIterable) {
    		if (collaboratorStores.contains(store.getStoreID()))
    			collaboratorStoresList.add(store);
    	}
    	model.addAttribute("collaboratorStoresList", collaboratorStoresList);
    	
		// ------------------ To Get System Brands ------------------
		Iterable<Brand> brandsIterable = brandRepo.findAll();
		List<Brand> systemBrandsList = new ArrayList<Brand>();
	
		for (Brand brand : brandsIterable) {
			systemBrandsList.add(brand);
		}
		model.addAttribute("systemBrandsList", systemBrandsList);
		
		return "collaboratorSuggestProduct";        					
	}
	
	@PostMapping("/cHome/actionAddProduct/{collaboratorId}")
	public String addActionAsADD(@PathVariable int collaboratorId, Model model, @ModelAttribute Product product)
	{
    	int productStoreID = product.getStoreID();
		product.setOwnerID(storeRepo.findOne(productStoreID).getOwnerID());
    	productRepo.save(product);
    	
    	Action actionADD = new Action(productStoreID, collaboratorId, product.getProductID(), "add");
    	actionRepo.save(actionADD);
    	
		return "redirect:/cHome";
	}
	
	@GetMapping("/cHome/showCollaboratorProducts/{user_id}")
    public String showProductsForSomeCollaborator(@PathVariable int user_id, Model model)
	{
		Collaborator currentCollaborator = collaboratorRepo.findOne(user_id);
		List<Integer> collaboratorStores = currentCollaborator.getStores();
		
		Iterable<Product> productsIterable = productRepo.findAll();
    	List<Product> collaboratorProductsList = new ArrayList<Product>();
    	
    	for (Product product : productsIterable) {
    		if (collaboratorStores.contains(product.getStoreID()))
    			collaboratorProductsList.add(product);
    	}
    	
    	model.addAttribute("collaboratorProductsList", collaboratorProductsList);
    	model.addAttribute("user_id", user_id);
    	return "showCollaboratorProducts";
	}
	
	//TODO: azbot el-edit in shaa Allah b3den
	@GetMapping("/cHome/actionEditProduct/{user_id}/{productId}")
	public String showEditProductForm(@PathVariable int productId, Model model)
	{
		Product currentProduct = productRepo.findOne(productId);
		model.addAttribute("currentProduct", currentProduct);
	    return "editProductForm";
	}
	
	@PostMapping("/cHome/actionEditProduct/{userId}/{productId}")
	public String addActionAsEdit(@PathVariable int userId, @PathVariable int productId, @RequestParam String newName,
			@RequestParam String newCategory, @RequestParam int newQuantity, @RequestParam int newPrice)
	{
		Product currentProduct = productRepo.findOne(productId);
		currentProduct.setProductName(newName);
		currentProduct.setCategory(newCategory);
		currentProduct.setQuantity(newQuantity);
		currentProduct.setPrice(newPrice);
		productRepo.save(currentProduct);
		return "redirect:/cHome/showCollaboratorProducts/{userId}";
	}

	@GetMapping("/cHome/actionDeleteProduct/{user_id}/{productId}")
	public String addActionAsDelete(@PathVariable int user_id, @PathVariable int productId, Model model)
	{
		Product product = productRepo.findOne(productId);
		
		int productID = productId;
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
		
		TempProduct temp = new TempProduct(productID, productName, category, productType, price, quantity, numOfViews, ownerID, brandID, storeID, confirmed, numberOfTimesSold);
		temp.setActionType("delete");
		// -- (1) -------
		tempProductRepo.save(temp);
		
		// -- (2) -------
		productRepo.delete(product); 						
		
		// -- (3) -------
		Action actionDELETE = new Action(storeID, user_id, productId, "delete");
    	actionRepo.save(actionDELETE);
		
		return "redirect:/cHome/showCollaboratorProducts/{user_id}";
	}

}



