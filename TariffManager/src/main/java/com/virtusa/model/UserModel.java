package com.virtusa.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;



public class UserModel {

	static Logger logger=Logger.getRootLogger();
	private int id;
	
	@NotBlank(message="email cannot be blank")
	private String email;
	
	@NotBlank(message="password cannot be blank")
	@Size(min=8,message="minimum length 8 required")
	private String password;
	
	@NotBlank(message="username required")
	private String username;
	
	@Size(min=10,max=10,message="enter correct 10 digit mobile Number")
	private String mobileNumber;
	
	@NotEmpty(message="required")
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		logger.debug("spring is using setter method to create the modelobject ");
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public UserModel(int id, String email, String password, String username, String mobileNumber,String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.role = role;
	}
	public UserModel() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + ", role=" + role + "]";
	}
		
}
