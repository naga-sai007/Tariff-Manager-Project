package com.nagasai.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SigUpModel {

	private int id;

	@NotBlank(message = "email cannot be blank")
	private String email;

	@NotBlank(message = "password cannot be blank")
	@Size(min = 8, message = "minimum length 8 required")
	private String password;

	@NotBlank(message = "username required")
	private String username;

	@Size(min = 10, max = 10, message = "enter correct 10 digit mobile Number")
	private String mobileNumber;

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

	@Override
	public String toString() {
		return "SigUpModel [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", mobileNumber=" + mobileNumber + "]";
	}

}
