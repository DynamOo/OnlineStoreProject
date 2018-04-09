package com.swe.entities;

import javax.persistence.Entity;

@Entity
public class NormalUser extends User{

	private boolean boughtBefore;
	private int numberOfProductsViewed, numberOfProductsBought;
	public NormalUser() {
		super();
		this.boughtBefore = false;
		this.numberOfProductsViewed = 0;
		this.numberOfProductsBought = 0;
	}

	public NormalUser(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
		this.boughtBefore = false;
		this.numberOfProductsViewed = 0;
		this.numberOfProductsBought = 0;
	}

	public boolean hasBoughtBefore() {
		return boughtBefore;
	}

	public void setBoughtBefore(boolean boughtBefore) {
		this.boughtBefore = boughtBefore;
	}

	public int getNumberOfProductsViewed() {
		return numberOfProductsViewed;
	}

	public void setNumberOfProductsViewed(int numberOfProductsViewed) {
		this.numberOfProductsViewed = numberOfProductsViewed;
	}

	public int getNumberOfProductsBought() {
		return numberOfProductsBought;
	}

	public void setNumberOfProductsBought(int numberOfProductsBought) {
		this.numberOfProductsBought = numberOfProductsBought;
	}

}
