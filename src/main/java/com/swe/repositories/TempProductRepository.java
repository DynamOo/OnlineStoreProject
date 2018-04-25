package com.swe.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.TempProduct;

public interface TempProductRepository extends CrudRepository<TempProduct, Integer> {
	
	List<TempProduct> findByProductID(int productID);
	TempProduct findOneByProductIDAndActionType(int productID, String actionType);
	
}
