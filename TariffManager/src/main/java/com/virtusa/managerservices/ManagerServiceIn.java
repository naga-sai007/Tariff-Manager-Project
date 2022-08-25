package com.virtusa.managerservices;

import java.util.List;

import com.virtusa.entity.Expense;
import com.virtusa.managermodel.ExpenseModel;
import com.virtusa.managermodel.UserModel;

public interface ManagerServiceIn {
	
	List<Expense> getExpensesList();
	void addExpense(ExpenseModel expense);	
	void approveExpense(int id);
	void declineExpense(int id);
}
