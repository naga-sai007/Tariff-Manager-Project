package com.nagasai.managerservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagasai.managerdao.ManagerDaoIn;
import com.nagasai.entity.Expense;
import com.nagasai.managermodel.ExpenseModel;

@Service
public class ManagerService implements ManagerServiceIn{

	@Autowired
	private ManagerDaoIn managerDao;
	
	@Override
	public List<Expense> getExpensesList() {

		return managerDao.getExpensesList();
		
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
		managerDao.addExpense(expense1,id);
		
	}

	@Override
	public void approveExpense(int id) {
		this.managerDao.approveExpense(id);
		
	}

	@Override
	public void declineExpense(int id) {

		this.managerDao.declineExpense(id);
	}



}
