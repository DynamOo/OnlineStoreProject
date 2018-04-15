package com.swe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Store {
	
	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name="storeID", unique=true)
	private int storeID;
	
	private int ownerID;
	private String storeName, location, storeType;
	private boolean confirmed;
	
	// First Trial
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="owner_fk", nullable=false)
//    private StoreOwner storeOwner;

	// Second Trial
//	private ArrayList<Product> products;
//	private ArrayList<Integer> keysOfProducts; // To save space :D
	
	String productsKeys;
	//int numOfUsersViewedStoreProducts, numOfUsersBoughtStoreProducts;

	public Store(int ownerID, int storeID, String storeName, String location, String storeType) {
		super();
		this.ownerID = ownerID;
		this.storeID = storeID;
		this.storeName = storeName;
		this.location = location;
		this.storeType = storeType;
//		this.products = new ArrayList<Product>();
//		this.keysOfProducts = new ArrayList<Integer>();
		this.confirmed = false;
		this.productsKeys = "";
	}
	
	public Store() {
		super();
		this.ownerID = 0;
		this.storeID = 0;
		this.storeName = "";
		this.location = "";
		this.storeType = "";
//		this.products = new ArrayList<Product>();
//		this.keysOfProducts = new ArrayList<Integer>();
		this.confirmed = false;
		this.productsKeys = "";
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
//	public StoreOwner getStoreOwner() {
//		return storeOwner;
//	}
//
//	public void setStoreOwner(StoreOwner storeOwner) {
//		this.storeOwner = storeOwner;
//	}

//	public ArrayList<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(ArrayList<Product> products) {
//		this.products = products;
//	}
//	
//	public ArrayList<Integer> getKeysOfProducts() {
//		return keysOfProducts;
//	}
//
//	public void setKeysOfProducts(ArrayList<Integer> keysOfProducts) {
//		this.keysOfProducts = keysOfProducts;
//	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	public List<Integer> getProductsKeys()
	{
	    List<Integer> productsIDs = new ArrayList<Integer>();
	    int singleProductID = 0;

	    for(String productID : this.productsKeys.split(","))
	    {
	        try {
	        	singleProductID = Integer.parseInt(productID);
	        }
	        // If the String contains other thing that digits and commas
	        catch (NumberFormatException e) {
	        }
	        productsIDs.add(singleProductID);
	    }

	    return productsIDs;
	}

	public void setProductsKeys(List<Integer> productsIDs)     // Ex: [1, 2, 3, 4, 55, 66]
	{
	    String newProductsIDs = "";
	    for(int productID : productsIDs)
	    {
	    	newProductsIDs += String.valueOf(productID)+",";
	    }
	    this.productsKeys = newProductsIDs;                   // Will be: 1,2,3,4,55,66,
	}
	
	// Utility Function
	public void addProductKey(int newproductID)
	{
		this.productsKeys += String.valueOf(newproductID)+",";
	}
}
