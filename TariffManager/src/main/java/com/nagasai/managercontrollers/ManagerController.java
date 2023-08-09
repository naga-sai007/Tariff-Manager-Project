package com.nagasai.managercontrollers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagasai.entity.Expense;
import com.nagasai.managermodel.ExpenseModel;
import com.nagasai.managerservices.ManagerServiceIn;

@Controller
public class ManagerController {

	@Autowired
	private ManagerServiceIn managerService;
	
	@RequestMapping(path="/manager")
	public ModelAndView managerHome(@ModelAttribute("expense") ExpenseModel expense,ModelAndView model) {
	
		List<String> statusList=new ArrayList<>();
		statusList.add("APPROVE");
		statusList.add("DECLINE");
		model.addObject("statusList",statusList);	
		List<Expense> expenseList=managerService.getExpensesList();
		model.addObject("expenseList", expenseList);
		model.setViewName("managerHome");
		return model;
	}
	@PostMapping(path="manager/expense/add")
	public ModelAndView addExpense(@Valid @ModelAttribute("expense") ExpenseModel expense,Errors errors,ModelAndView model) {
		if(errors.hasErrors())	
		{
			model.setViewName("managerHome");
			return model;
		}
		else {
		managerService.addExpense(expense);
		model.setViewName("redirect:/manager");
		return model;
		}
	}
	
	@PostMapping(path = "manager/expense/{id}")
	public ModelAndView ApproveExpense(@PathVariable int id, Model model) {

		this.managerService.approveExpense(id);
		return new ModelAndView("redirect:/manager");

	}

	@GetMapping(path = "manager/expense/{id}")
	public ModelAndView declineExpense(@PathVariable int id, Model model) {
		this.managerService.declineExpense(id);
		return new ModelAndView("redirect:/manager");
	}
	
	
	
}
