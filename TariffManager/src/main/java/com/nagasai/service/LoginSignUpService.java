package com.nagasai.service;


import com.nagasai.model.SigUpModel;
import com.nagasai.model.UserModel;

public interface LoginSignUpService {

  void register(SigUpModel user);
  UserModel getUserByEmail(String email);
}
