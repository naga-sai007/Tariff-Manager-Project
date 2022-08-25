package com.virtusa.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.virtusa.entity.User;
import com.virtusa.model.UserModel;

public interface AdminServiceIn {

	boolean checkCredentials(String email, String password);

	List<User> getUserList();

	List<User> getUsersByUserName(String username);

	boolean addUser(UserModel user) throws DataIntegrityViolationException;

	void editUserById(int id, UserModel user);

	void deleteUserById(int id);

	User getUserByUserId(int id);
}
