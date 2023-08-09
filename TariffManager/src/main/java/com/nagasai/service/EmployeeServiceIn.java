package com.nagasai.service;

import java.util.List;

import com.nagasai.entity.Expense;
import com.nagasai.model.ExpenseModel;



public interface EmployeeServiceIn {
	
	List<Expense> getExpensesList(int id);
	void addExpense(ExpenseModel expense);
}
