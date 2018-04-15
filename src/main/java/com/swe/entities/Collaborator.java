package com.swe.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Collaborator extends User{
	
	private String stores;
	
	public Collaborator() {
		super();
		stores = "";
	}

	public Collaborator(int id, String firstName, String lastName, String email, String password, String address,
			String phoneNumber, String type, int age) {
		super(id, firstName, lastName, email, password, address, phoneNumber, type, age);
		stores = "";
	}
	
	public List<Integer> getStores()
	{
	    List<Integer> StoresIDs = new ArrayList<Integer>();
	    int singleStoreID = 0;

	    for(String storeID : this.stores.split(","))
	    {
	        try {
	        	singleStoreID = Integer.parseInt(storeID);
	        }
	        // If the String contains other thing that digits and commas
	        catch (NumberFormatException e) {
	        }
	        StoresIDs.add(singleStoreID);
	    }

	    return StoresIDs;
	}

	public void setStores(List<Integer> storesIDs)     // Ex: [1, 2, 3, 4, 55, 66]
	{
	    String newStoresIDs = "";
	    for(int storeID : storesIDs)
	    {
	    	newStoresIDs += String.valueOf(storeID)+",";
	    }
	    this.stores = newStoresIDs;                   // Will be: 1,2,3,4,55,66,
	}
	
	// Utility Function
	public void addStore(int newStoreID)
	{
		this.stores += String.valueOf(newStoreID)+",";
	}
	
}
