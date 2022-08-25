package com.virtusa.service;


import com.virtusa.model.SigUpModel;
import com.virtusa.model.UserModel;

public interface LoginSignUpService {

  void register(SigUpModel user);
  UserModel getUserByEmail(String email);
}
