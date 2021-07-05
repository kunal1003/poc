package com.assignment.crud.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.crud.example.entity.RegisterUser;

public interface RegUserRepo extends JpaRepository<RegisterUser	,Integer> {

	RegisterUser findByName(String name);

	RegisterUser findBySurname(String surname);

	RegisterUser findByPincode(String pincode);

	@Query("select r from RegisterUser r order by dob") 
	List<RegisterUser> findAllOrderByDobDesc();

	@Query("select r from RegisterUser r order by joiningdate")
	List<RegisterUser> findAllOrderByJoiningDateDesc();

}
