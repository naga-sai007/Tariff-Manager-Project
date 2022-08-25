package com.virtusa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.model.Login;
import com.virtusa.model.UserModel;
import com.virtusa.service.LoginSignUpService;

@Controller
public class LoginController {

	@Autowired
	LoginSignUpService userService;

	@RequestMapping(path = "/")
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login")
	public ModelAndView showLogin(@ModelAttribute("login") Login login, ModelAndView model) {
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/loginProcess")
	public ModelAndView loginProcess( Login login,HttpSession session) {
		
	String email=(String) session.getAttribute("email");
	
		UserModel user = userService.getUserByEmail(email);

		if (user != null) {
			ModelAndView model=new ModelAndView();
			model.addObject("id", user.getId());
			model.setViewName("redirect:/"+user.getRole().toLowerCase());
				return model;
			} 
		else { 
				 ModelAndView model=new ModelAndView();
				 model.setViewName("login");
			     model.addObject("message", "Username or Password is wrong!!"); return model;
			  }
			 
	}
	
	@RequestMapping("/logoutSuccessful")
	public ModelAndView logout() {
		return new ModelAndView("redirect:/");
	}
}
