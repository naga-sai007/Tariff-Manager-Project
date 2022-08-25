package com.virtusa.managerdao;

import java.util.List;

import com.virtusa.entity.Expense;
import com.virtusa.entity.User;

public interface ManagerDaoIn {

	List<Expense> getExpensesList();
	void addExpense(Expense expense,int id);
	void approveExpense(int id);
	void declineExpense(int id);
}
