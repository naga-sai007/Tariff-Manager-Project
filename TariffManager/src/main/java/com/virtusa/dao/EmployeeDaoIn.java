package com.virtusa.dao;

import java.util.List;

import com.virtusa.entity.Expense;



public interface EmployeeDaoIn {

	List<Expense> getExpensesList(int id);
	void addExpense(Expense expense,int id);
}

