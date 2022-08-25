package com.virtusa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.virtusa.dao.UserDaoIn;
import com.virtusa.entity.User;
import com.virtusa.model.UserModel;

@Service
public class AdminService implements AdminServiceIn {

	@Autowired
	private UserDaoIn userDao;

	public boolean checkCredentials(String email, String password) {
		return (userDao.checkCredentials(email, password));
	}

	public List<User> getUserList() {
		return (userDao.getUserList());
	}

	public List<User> getUsersByUserName(String username) {
		return (userDao.getUsersByUserName(username));
	}

	public boolean addUser(UserModel user) throws DataIntegrityViolationException {
		User user1 = new User();
		user1.setEmail(user.getEmail());
		user1.setMobileNumber(user.getMobileNumber());
		user1.setUsername(user.getUsername());
		user1.setRole(user.getRole());
		user1.setPassword(user.getPassword());

		return (userDao.addUser(user1));
	}

	public void editUserById(int id, UserModel user) throws DataIntegrityViolationException {
		User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setId(id);
		user1.setEmail(user.getEmail());
		user1.setMobileNumber(user.getMobileNumber());
		user1.setRole(user.getRole());
		userDao.editUserById(id, user1);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	public User getUserByUserId(int id) {

		return (userDao.getUserByUserId(id));
	}

}
