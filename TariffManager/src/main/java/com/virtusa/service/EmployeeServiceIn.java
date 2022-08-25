package com.virtusa.service;

import java.util.List;

import com.virtusa.entity.Expense;
import com.virtusa.model.ExpenseModel;



public interface EmployeeServiceIn {
	
	List<Expense> getExpensesList(int id);
	void addExpense(ExpenseModel expense);
}
