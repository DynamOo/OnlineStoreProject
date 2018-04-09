package com.swe.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand implements Serializable {

	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name="brandID", unique=true)
	private int brandID;
	
	private String brandName, brandCategory;
	private boolean confirmed;

	public Brand(int brandID, String brandName, String brandCategory) {
		super();
		this.brandID = brandID;
		this.brandName = brandName;
		this.brandCategory = brandCategory;
	}
	
	public Brand() {
		super();
		this.brandID = 0;
		this.brandName = "";
		this.brandCategory = "";
	}

	public int getBrandID() {
		return brandID;
	}

	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandCategory() {
		return brandCategory;
	}

	public void setBrandCategory(String brandCategory) {
		this.brandCategory = brandCategory;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}
