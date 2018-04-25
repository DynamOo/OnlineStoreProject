package com.swe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TempProduct {
	
	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name="temp_product_id", unique=true)
	private int tempProductID;
	
	private int productID;
	
	private String productName, category, productType, actionType;
	
	private int price, quantity, numOfViews, ownerID, brandID, storeID;
	private boolean confirmed;
	
	private int numberOfTimesSold;
  	
	public TempProduct(int productID, String productName, String category, String productType, int price,
			int quantity, int numOfViews, int ownerID, int brandID, int storeID, boolean confirmed, int numberOfTimesSold) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.numOfViews = numOfViews;
		this.ownerID = ownerID;
		this.brandID = brandID;
		this.storeID = storeID;
		this.confirmed = confirmed;
		this.numberOfTimesSold = numberOfTimesSold;
		this.actionType = "";
	}
	
	public TempProduct(int productID, String productName, String category, String productType, int price,
			int quantity, int ownerID, int brandID, int storeID) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.numOfViews = 0;
		this.ownerID = ownerID;
		this.brandID = brandID;
		this.storeID = storeID;
		this.confirmed = false;
		this.numberOfTimesSold = 0;
	}
	
	public TempProduct() {
		super();
		this.productID = 0;
		this.productName = "";
		this.category = "";
		this.productType = "";
		this.price = 0;
		this.quantity = 0;
		this.numOfViews = 0;
		this.ownerID = 0;
		this.brandID = 0;
		this.storeID = 0;
		this.confirmed = false;
		this.numberOfTimesSold = 0;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumOfViews() {
		return numOfViews;
	}

	public void setNumOfViews(int numOfViews) {
		this.numOfViews = numOfViews;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getNumberOfTimesSold() {
		return numberOfTimesSold;
	}

	public void setNumberOfTimesSold(int numberOfTimesSold) {
		this.numberOfTimesSold = numberOfTimesSold;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
}