package com.virtusa.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.virtusa.entity.User;

@Repository
public class LoginSignUpDaoImpl implements LoginSignUpDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public void register(User user) throws DataIntegrityViolationException {
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		System.out.println(email);
		String sqlQuery="select u from User u where u.email=?0";
		List<User> users = (List<User>) hibernateTemplate.find(sqlQuery, email);
		try {
			User userdb = users.get(0);
			return userdb; 
			}
			catch(NullPointerException ex) {
				return null;
        	}
		catch(IndexOutOfBoundsException ex){  
			return null; 
			}
	}
}