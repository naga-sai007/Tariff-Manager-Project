package com.nagasai.managerdao;

import java.util.List;

import com.nagasai.entity.Expense;

public interface ManagerDaoIn {

	List<Expense> getExpensesList();
	void addExpense(Expense expense,int id);
	void approveExpense(int id);
	void declineExpense(int id);
}
