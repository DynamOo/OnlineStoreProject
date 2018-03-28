package com.swe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swe.entities.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> { // bb3tlo class Store w el-PK bta3y elly
																		  // mn no3 integer hna (ID)

	// This will be AUTO IMPLEMENTED by Spring into a Bean called StoreRepository
	// CRUD refers Create, Read, Update, Delete

	// 3mlnaha interface 3shan el-functions elly gwa CrudRepository is implemented
	// during the run time
	// fa CrudRepository de aslun abstract class w gwaha functions bt3ml wazeftha
	// 3la 7sab ana ba3tlaha a w el-data type bta3 el-PK
	// (hb3tlha object mn class Store fe 7altna de w el-data type no3o integer)
	// w hagy fe el-controller h-depened 3la class StoreRepository
}

