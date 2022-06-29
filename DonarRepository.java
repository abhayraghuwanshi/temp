package com.iiht.training.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.ngo.entity.DonarEntity;

/*
DonarRepository (interface)
	1.	Repository interface exposing CRUD functionality for DonarEntity Entity.
2.	You can go ahead and add any custom methods as per requirements	Partially implemented

*/

@Repository
public interface DonarRepository extends JpaRepository<DonarEntity, Long> {

	
}
