package com.nagasai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagasai.exception.SqlIntegrityViolation;
import com.nagasai.model.SigUpModel;
import com.nagasai.model.UserModel;
import com.nagasai.service.LoginSignUpService;

@Controller
public class SignUpController {
	@Autowired
	public LoginSignUpService userService;

	@GetMapping(value = "/signup")
	public ModelAndView showRegister(@ModelAttribute("user") UserModel user, ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	@PostMapping(value = "/registerProcess")
	public ModelAndView addUser(@Valid @ModelAttribute("user") SigUpModel user, Errors errors, ModelAndView model) throws SqlIntegrityViolation {

		if (errors.hasErrors()) {
			System.out.println(errors.getErrorCount());
			System.out.println(errors.toString());
			model.setViewName("register");
			model.addObject("message", "Enter required Details!!");
			return model;
		} else {
			try {
			userService.register(user);
			return new ModelAndView("redirect:/login");
			}
			catch(DataIntegrityViolationException ex)
			{
				throw new SqlIntegrityViolation("User already exists or mail Id already registered");
			}
		}
	}
}
