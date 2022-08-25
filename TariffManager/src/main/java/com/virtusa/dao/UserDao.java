package com.virtusa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.entity.User;

@Repository
public class UserDao implements UserDaoIn {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public boolean checkCredentials(String email, String password)  {

		String query = "from User where email=?0";
		ArrayList<User> userList = (ArrayList<User>) hibernateTemplate.find(query, email);
		try {
			User userdb = userList.get(0);
			String emaildb = userdb.getEmail();
			String passworddb = userdb.getPassword();
			return (emaildb.equals(email) && passworddb.equals(password));
	}catch(NullPointerException ex) {
		return false;
	}
	}

	@Transactional
	public List<User> getUserList() {
		String query = "from User";
		return (ArrayList<User>) hibernateTemplate.find(query);
	}

	@Transactional
	public List<User> getUsersByUserName(String username) {
		String query = "select user from User user" + " where user.username LIKE CONCAT('%',?0,'%')";
		return (ArrayList<User>) hibernateTemplate.find(query, username);
	}

	@Transactional
	public boolean addUser(User user) throws DataIntegrityViolationException {

		int id = (Integer) this.hibernateTemplate.save(user);
		return (id == 1);

	}

	@Transactional
	public void editUserById(int id, User user) throws DataIntegrityViolationException{
		String username = user.getUsername();
		String email = user.getEmail();
		String mobileNumber = user.getMobileNumber();
		String role = user.getRole();

		SessionFactory session = hibernateTemplate.getSessionFactory();
		Session session2 = session.getCurrentSession();
		User user1 = session2.get(User.class, id);
		user1.setUsername(username);
		user1.setEmail(email);
		user1.setMobileNumber(mobileNumber);
		user1.setRole(role);

	}

	@Transactional
	public void deleteUserById(int id) {
		hibernateTemplate.delete(hibernateTemplate.get(User.class, id));
	}

	public User getUserByUserId(int id) {

		return hibernateTemplate.get(User.class, id);
	}

}
