package com.nagasai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagasai.entity.Expense;
import com.nagasai.model.ExpenseModel;
import com.nagasai.service.EmployeeServiceIn;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceIn employeeService;

	@GetMapping(path = "/employee")
	public ModelAndView employeeHome(@ModelAttribute("expense") ExpenseModel expense, ModelAndView modelView,@RequestParam("id") int id) {
		modelView.addObject("id", id);
		List<Expense> expenseList = employeeService.getExpensesList(id);
		modelView.addObject("expenseList", expenseList);
		modelView.setViewName("expenseHome");
		return modelView;
	}

	@PostMapping(path = "employee/expense/add")
	public ModelAndView addExpense(@Valid @ModelAttribute("expense") ExpenseModel expense,Errors errors, ModelAndView model) {
		if(errors.hasErrors())
		{
			model.addObject("id",expense.getId());
			return new ModelAndView("expenseHome");
		}
		else {
		int id = expense.getId();
		employeeService.addExpense(expense);
		model.addObject("id", id);
		model.setViewName("redirect:/employee");
		return model;
		}
	}

	
}
