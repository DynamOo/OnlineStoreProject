package com.swe.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class StoreOwner extends User{
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="storeOwner") // the name of the table in the database (WRONG)
//    private Set<Store> stores;
//	private Collection<Store> stores = new ArrayList<Store>();   // If I want to use list NOT set
	
	
//	public Set<Store> getStores() {
//		return stores;
//	}
//
//	public void setStores(Set<Store> stores) {
//		this.stores = stores;
//	}

	public StoreOwner() {
		super();
		//stores = new HashSet<Store>();
	}

	public StoreOwner(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
		//stores = new HashSet<Store>();
	}
	
}
