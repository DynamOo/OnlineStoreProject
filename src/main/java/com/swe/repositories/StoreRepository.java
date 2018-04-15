package com.swe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {
																		  	
//	List<Store> findByQuantity(int quantity);
//	List<Store> findByNumberOfTimesSoldOrderByNumberOfTimesSoldDesc(int numberOfTimesSold);
	
//	@Query("SELECT AVG(u.age) from User u") // To write JPQL queries (Java Persistence Query Language)
//    int getAverageAge();
 
//    @Query(value = "SELECT max(age) from User where first_name <> ?1", nativeQuery = true) // To write native SQL queries
//    int getMaxAgeMinus(String name);
}

