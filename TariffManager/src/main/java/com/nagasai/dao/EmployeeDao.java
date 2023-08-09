package com.nagasai.dao;

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
public class EmployeeDao implements EmployeeDaoIn {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	@Override
	public List<Expense> getExpensesList(int id) {
		SessionFactory session = hibernateTemplate.getSessionFactory();
		Session session2 = session.getCurrentSession();
		User user1 = session2.get(User.class, id);
		List<Expense> expenseList = user1.getExpense();
		return expenseList;
	}

	@Transactional
	@Override
	public void addExpense(Expense expense, int id) {

		SessionFactory session = hibernateTemplate.getSessionFactory();
		Session session2 = session.getCurrentSession();
		User user1 = session2.get(User.class, id);
		user1.getExpense().add(expense);
		hibernateTemplate.save(user1);
	}

	

}
