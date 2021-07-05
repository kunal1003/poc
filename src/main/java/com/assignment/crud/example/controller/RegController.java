package com.assignment.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.crud.example.entity.RegisterUser;
import com.assignment.crud.example.service.RegUserService;

@RestController
@RequestMapping("/reg")
public class RegController {

	
	@Autowired
	RegUserService rserv;
	

	@GetMapping("/a")
	public String add() {
		return "hello user" ;
	}
	
	@PostMapping(value="/adduser1")
	public RegisterUser adduser( @Valid @RequestBody RegisterUser ruser) {
		
		return rserv.saveuser(ruser);
	}
	
	/*
	 * @PostMapping("/addusers") public List<RegisterUser> addusers(@RequestBody
	 * List<RegisterUser> rusers) { return rserv.saveuserlist(rusers); }
	 */
	
	@GetMapping("/getuserbyid/{id}")
	public RegisterUser findUserById(@PathVariable int id) {
		return rserv.getUserById(id);
	}
	
	
	@GetMapping("/getuserbyname/{name}")
	public RegisterUser findUserbyName(@PathVariable String name) {
		
		return rserv.getUserByName(name);
	}
	
	@GetMapping("/getuserbysurname/{surname}")
	public RegisterUser findUserbySurname(@PathVariable String surname) {
		return rserv.getUserBySurname(surname);
	}
	
	@GetMapping("/getuserbypin/{pincode}")
	public RegisterUser findUserByPin(@PathVariable String pincode) {
		return rserv.getUserBypincode(pincode);
	}
	
	@PutMapping("/updateuser")
	public RegisterUser updateuser(@RequestBody RegisterUser ruser) {
		
		return rserv.UpdateUser(ruser);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable int id) {
		return rserv.deleteuser(id);
		
	}
	
	@GetMapping("/sortbydob")
	public List<RegisterUser> sortuserbydob() {
		return rserv.getEmployeeOrderByDateOfBirth();
	}
	
	@GetMapping("/sortbyjoiningdate")
	public List<RegisterUser> sortuserbyjoiningdate() {
		return rserv.getEmployeeOrderByJoiningDate();
	}
	
}
