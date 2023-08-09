package com.nagasai.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.nagasai.entity.User;

public interface UserDaoIn {

	boolean checkCredentials(String email, String password);

	List<User> getUserList();

	List<User> getUsersByUserName(String username);

	boolean addUser(User user) throws DataIntegrityViolationException;

	void editUserById(int id, User user);

	void deleteUserById(int id);

	User getUserByUserId(int id);
}
