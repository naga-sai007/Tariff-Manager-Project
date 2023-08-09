package com.nagasai.managerservices;

import java.util.List;

import com.nagasai.entity.Expense;
import com.nagasai.managermodel.ExpenseModel;

public interface ManagerServiceIn {
	
	List<Expense> getExpensesList();
	void addExpense(ExpenseModel expense);	
	void approveExpense(int id);
	void declineExpense(int id);
}
