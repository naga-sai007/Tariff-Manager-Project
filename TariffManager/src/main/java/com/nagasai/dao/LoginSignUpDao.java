package com.nagasai.dao;

import com.nagasai.entity.User;

public interface LoginSignUpDao {

	void register(User user);
	User getUserByEmail(String email);
}
