package com.swe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.Action;

public interface ActionRepository extends CrudRepository<Action, Integer> {
	
	//List<Action> findByStoreID(int storeID);

	List<Action> findByStoreID(int store_id);
	
}
