package com.nagasai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagasai.dao.LoginSignUpDao;
import com.nagasai.entity.User;
import com.nagasai.model.SigUpModel;
import com.nagasai.model.UserModel;

@Service
public class LoginSignUpServiceImpl implements LoginSignUpService {

  @Autowired
  public LoginSignUpDao userDao;
  
@Transactional
  public void register(SigUpModel user) throws DataIntegrityViolationException{
	User user1 = new User();
	user1.setEmail(user.getEmail());
	user1.setUsername(user.getUsername());
	user1.setMobileNumber(user.getMobileNumber());
	user1.setPassword(user.getPassword());
	user1.setRole("Employee");
	user1.setActive(true);
     userDao.register(user1);
  }

@Transactional
  public UserModel getUserByEmail(String email) {
	
    try {
    User user1 = userDao.getUserByEmail(email);
    UserModel userModel = new UserModel();
    userModel.setRole(user1.getRole());
    userModel.setId(user1.getId());
    userModel.setUsername(user1.getUsername());
    userModel.setEmail(user1.getMobileNumber());
    return userModel;
    } catch(NullPointerException ex) {
    	return null;
    }
    }
    }