package com.swe.entities;

import javax.persistence.Entity;

@Entity
public class StoreOwner extends User{

	public StoreOwner() {
		super();
	}

	public StoreOwner(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
	}
	
}
