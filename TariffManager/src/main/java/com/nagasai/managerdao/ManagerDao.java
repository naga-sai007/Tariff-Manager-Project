package com.nagasai.managerdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagasai.entity.Expense;
import com.nagasai.entity.User;

@Repository
public class ManagerDao implements ManagerDaoIn {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	@Override
	public List<Expense> getExpensesList() {			
		String sql="from User ";		
		hibernateTemplate.find(sql);
		String query="from Expense e where e.status='Awaiting For Approval'";
		return (List<Expense>) (hibernateTemplate.find(query));		
	}

	@Transactional
	@Override
	public void addExpense(Expense expense,int id) {

		SessionFactory session = hibernateTemplate.getSessionFactory();
		Session session2 = session.getCurrentSession();
		User user1 = session2.get(User.class, id);
		user1.getExpense().add(expense);
		hibernateTemplate.save(user1);
	}

	@Transactional
	@Override
	public void approveExpense(int id) {
		Expense expense = hibernateTemplate.get(Expense.class,id);
		expense.setStatus("Approved");
		hibernateTemplate.update(expense);
		
	}
	@Transactional
	@Override
	public void declineExpense(int id) {
		Expense expense = hibernateTemplate.get(Expense.class,id);
		expense.setStatus("Declined");
		hibernateTemplate.update(expense);
		
	}


}
