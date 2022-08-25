package com.virtusa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServiceIn {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(String email, String username, String passWord) {

		SimpleMailMessage newEmail = new SimpleMailMessage();
		newEmail.setTo(email);
		newEmail.setSubject("Tariff Manager Account Details");
		newEmail.setText("Hii" + username + ", Your Account  for tariffmanager.com is created with mail Id:" + email
				+ " password  is :" + passWord + "Please,Login and change the password, Thanks. From Admin");
		mailSender.send(newEmail);
	}

}
