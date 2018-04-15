package com.swe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.swe.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
//	List<Store> findByQuantity(int quantity);
//	List<Store> findByNumberOfTimesSoldOrderByNumberOfTimesSoldDesc(int numberOfTimesSold);
	
//	@Query(value = "SELECT sum(numOfViews) from Product where storeID = ?1", nativeQuery = true) // Unknown column 'numOfViews' in 'field list' Error
	// so I should get the names of the fields from MySQL
	
	// ?1 means assign here the first @Param, ?2 means assign here the second @Param, and so on...
	
	@Query(value = "SELECT sum(num_of_views) from product where storeid = ?1", nativeQuery = true) // , nativeQuery = true .. to write native SQL queries
	int getTotalNumberOfViews(@Param("store_id") int store_id);
	
	@Query(value = "SELECT sum(number_of_times_sold) from product where storeid = ?1", nativeQuery = true)
	int getTotalNumberOfPurchases(@Param("store_id") int store_id);
	
	List<Product> findByQuantityAndStoreID(int quantity, int storeID);
	List<Product> findByStoreIDOrderByNumberOfTimesSoldDesc(int storeID);
	List<Product> findByOwnerID(int ownerID);
}


