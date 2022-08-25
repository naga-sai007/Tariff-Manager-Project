package com.virtusa.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUserModel {

	@NotEmpty(message="email Required")
	private String email;
	
	@NotEmpty(message="password Required")
	@Size(min=8,message="min 8 characters required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUserModel [email=" + email + ", password=" + password + "]";
	}

	public LoginUserModel(@NotEmpty(message = "email Required") String email,
			@NotEmpty(message = "password Required") @Size(min = 8, message = "min 8 characters required") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginUserModel() {
		super();
	}
	
	
}
