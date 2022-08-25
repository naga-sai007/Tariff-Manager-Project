package com.virtusa.dao;

import com.virtusa.entity.User;

public interface LoginSignUpDao {

	void register(User user);
	User getUserByEmail(String email);
}
