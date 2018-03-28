package com.swe.entities;

import java.util.ArrayList;

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
	
	//private int ownerID;
	private String storeName, location, storeType;
	private boolean confirmed;
	
	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="OWNER_ID_TEST", nullable=false)
	@JoinColumn(name="owner_id", nullable=false)
    private StoreOwner storeOwner;

	private ArrayList<Product> products;

	public Store(int ownerID, int storeID, String storeName, String location, String storeType) {
		super();
		//this.ownerID = ownerID;
		this.storeID = storeID;
		this.storeName = storeName;
		this.location = location;
		this.storeType = storeType;
		this.products = new ArrayList<Product>();
		this.confirmed = false;
		//this.storeOwner = new StoreOwner();
	}
	
	public Store() {
		super();
		//this.ownerID = 0;
		this.storeID = 0;
		this.storeName = "";
		this.location = "";
		this.storeType = "";
		this.products = new ArrayList<Product>();
		this.confirmed = false;
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
	
	public StoreOwner getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(StoreOwner storeOwner) {
		this.storeOwner = storeOwner;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

//	public int getOwnerID() {
//		return ownerID;
//	}
//
//	public void setOwnerID(int ownerID) {
//		this.ownerID = ownerID;
//	}
	
}
