package com.swe.entities;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {
	
	public Administrator() {
		super();
	}

	public Administrator(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
	}
	
}
