package com.assignment.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.assignment.crud.example.entity.RegisterUser;
import com.assignment.crud.example.repository.RegUserRepo;

@Service
public class RegUserService {

	@Autowired
    RegUserRepo repository;
	
	
	public RegisterUser saveuser (RegisterUser ruser) {
		return repository.save(ruser);
	}
	
	/*
	 * public List<RegisterUser> saveuserlist(List<RegisterUser> regusers) { return
	 * repository.saveAll(regusers); }
	 * 
	 * 
	 * public List <RegisterUser> getuser(){ return repository.findAll(); }
	 */
	
	public RegisterUser getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public RegisterUser updateReguser(RegisterUser reguser) {
		return reguser;
	}
	
	
	public RegisterUser getUserByName(String name) {
		return repository.findByName(name); 
	}
	
	public RegisterUser getUserBySurname(String surname) {
		return repository.findBySurname(surname);
	}
	
	public RegisterUser getUserBypincode(String pincode) {
		return repository.findByPincode(pincode);
	}
	
	public RegisterUser UpdateUser(RegisterUser ruser) {
	
		
		RegisterUser reguser = repository.findById(ruser.getId()).orElse(null);
		reguser.setName(ruser.getName());
		reguser.setSurname(ruser.getSurname());
		reguser.setPincode(ruser.getPincode());
		reguser.setJoiningdate(ruser.getJoiningdate());
		reguser.setDob(ruser.getDob());
		return repository.save(reguser);	
	}
	
	
	public String deleteuser(int id) {
		repository.deleteById(id);
		
		return " User Removed " + id ;
		
	}
	
	
	public List<RegisterUser> getEmployeeOrderByDateOfBirth()
	{
		return repository.findAllOrderByDobDesc();
	}
	
	public List<RegisterUser> getEmployeeOrderByJoiningDate()
	{
		return repository.findAllOrderByJoiningDateDesc();
	}



	
	
}
