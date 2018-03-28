package com.swe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name="productID", unique=true)
	private int productID;
	
	private String productName,
		   category,
		   brandName,
		   productType;
	
	private int price, quantity, numOfViews;

	public Product(int productID, String productName, String category, String brandName, String productType, int price,
			int quantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.category = category;
		this.brandName = brandName;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.numOfViews = 0;
	}
	
	public Product() {
		super();
		this.productID = 0;
		this.productName = "";
		this.category = "";
		this.brandName = "";
		this.productType = "";
		this.price = 0;
		this.quantity = 0;
		this.numOfViews = 0;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	
}
