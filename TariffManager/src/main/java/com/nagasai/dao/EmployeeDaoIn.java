package com.nagasai.dao;

import java.util.List;

import com.nagasai.entity.Expense;



public interface EmployeeDaoIn {

	List<Expense> getExpensesList(int id);
	void addExpense(Expense expense,int id);
}

