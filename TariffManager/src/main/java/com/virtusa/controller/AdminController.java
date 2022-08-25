package com.virtusa.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.entity.User;
import com.virtusa.exception.SqlIntegrityViolation;
import com.virtusa.model.UserModel;
import com.virtusa.service.AdminService;
import com.virtusa.service.EmailServiceIn;

@Controller
public class AdminController {

	static Logger logger=Logger.getRootLogger();
	private String homeUrl = "redirect:/admin";
	@Autowired
	private AdminService adminService;
	@Autowired
	private EmailServiceIn emailService;
	
	@Value("#{professionList}")
	private Map<String,String> professionList;
	
	@GetMapping(path = "admin")
	public String adminHomePage(@ModelAttribute("user") UserModel user,Model model) {
		List<User> userList = this.adminService.getUserList();
		model.addAttribute(userList);
	        model.addAttribute("professionList", professionList);
	         
		return "adminHome";
	}

	@RequestMapping("/admin/user/add")
	public ModelAndView addUser(@Valid @ModelAttribute("user") UserModel user,Errors errors,ModelAndView model) throws SqlIntegrityViolation {
		
		if(errors.hasErrors())
		{
          model.addObject("professionList", professionList);
			model.setViewName("adminHome");
			return model;
		}
		else {
			try {
				adminService.addUser(user);
				emailService.sendMail(user.getEmail(),user.getUsername(),user.getPassword());
				return new ModelAndView(homeUrl);
			}
			catch(DataIntegrityViolationException ex)
			{
				throw new SqlIntegrityViolation("User already exists");
			}
		}
	}

	

	@GetMapping(path = "/admin/user/{id}")
	public ModelAndView deleteUser(@PathVariable int id, Model model) {
		this.adminService.deleteUserById(id);
		return new ModelAndView(homeUrl);
	}

	@PostMapping(path = "/admin/user/{id}")
	public ModelAndView editUser(@ModelAttribute("user") UserModel user, ModelAndView modelView) {
		logger.debug("edit method called");
	        modelView.addObject("professionList", professionList);
	       User user1= adminService.getUserByUserId(user.getId());
	       modelView.addObject("user", user1);
		modelView.setViewName("editUser");
		return modelView;
	}

	@PostMapping(path = "/admin/user/edit")
	public ModelAndView editUserDetails(@ModelAttribute("user") UserModel user,Model model) throws SqlIntegrityViolation {
		logger.debug("onsubmit of edit button");
		try {
		this.adminService.editUserById(user.getId(), user);
	 return new ModelAndView(homeUrl);
	}
		catch(DataIntegrityViolationException ex)
		{
			throw new SqlIntegrityViolation("You cant edit the usermail to existing email");
		}
	}
		
	
	@RequestMapping(path="/admin/user/search")
	public ModelAndView searchUser(@ModelAttribute("user") UserModel user,ModelAndView modelView)
	{
		
		List<User> searchList=this.adminService.getUsersByUserName(user.getUsername());
	        modelView.addObject("professionList", professionList);
		modelView.addObject("searchList",searchList);
		modelView.setViewName("searchListPage");
		return modelView;
	}
	
	@GetMapping(path="/admin/user/home")
	public String gotoHomePage() {
		return "redirect:/admin";
	}
	
}
