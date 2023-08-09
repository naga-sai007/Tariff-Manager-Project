package com.nagasai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagasai.dao.EmployeeDaoIn;
import com.nagasai.entity.Expense;
import com.nagasai.model.ExpenseModel;



@Service
public class EmployeeService implements EmployeeServiceIn{

	@Autowired
	private EmployeeDaoIn employeeDao;
	
	@Override
	public List<Expense> getExpensesList(int id) {

		return employeeDao.getExpensesList(id);
		
	}

	@Override
	public void addExpense(ExpenseModel expense) {

		Expense expense1=new Expense();
		expense1.setBillCost(expense.getBillCost());
		expense1.setBillImage(expense.getBillImage());
		expense1.setBillNumber(expense.getBillNumber());
		expense1.setDatedOn(expense.getDatedOn());
		expense1.setExpenseId(expense.getExpenseId());
		expense1.setRemark(expense.getRemark());
		expense1.setStatus("Awaiting For Approval");
		int id=expense.getId();
		employeeDao.addExpense(expense1,id);
		
	}
}

