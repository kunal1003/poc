package com.assignment.crud.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
@Table(name="reguser_tbl")
public class RegisterUser {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy= GenerationType.AUTO) private int id; private String
	 * name; private String surname; private String pincode; private String dob;
	 * private String joiningdate;
	 */
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@NotNull (message="name cannot be null")
	@Size(min=2,message="name must be greater than 2 characters")
	private String name;
	
	@NotNull(message="surname cannot be null")
	@Size(min=2,message="surname must be greater than 2 characters")
	private String surname;
	
	@NotNull(message ="pincode cannot be null")
	@Size(min=4,message="pincode must be greater than 4 characters")
	private String pincode;
	
	@NotNull(message="dob cannot be null")
	@JsonFormat(pattern="dd-mm-yyyy")
	private String dob;
	
	@NotNull(message="joining date cannot be null")
	@JsonFormat(pattern="dd-mm-yyyy")
	private String joiningdate;
	
	public RegisterUser(int id, String name, String surname, String pincode, String dob, String joiningdate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pincode = pincode;
		this.dob = dob;
		this.joiningdate = joiningdate;
	}
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}
	@Override
	public String toString() {
		return "RegisterUser [id=" + id + ", name=" + name + ", surname=" + surname + ", pincode=" + pincode + ", dob="
				+ dob + ", joiningdate=" + joiningdate + "]";
	}
	
	
	
	
}
