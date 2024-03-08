package com.code.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Users;

@Repository
public class UserDao implements IUserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		/* Initially we gave "session.save(user)" alone in this createUser(Users user) but then wen we try
		 * to update, again it takes to user_registration.jsp file and wen we try to change/update the
		 * credentials other than emailid(we can't change emailid bcoz it's a primary key),in UserController
		 * .java, the method userService.createUser(usr) tries to CREATE a new record and not UPDATING as it
		 * is done by another method called "public int updateUser(Users user)" in UserDao.java. So, we are
		 * making "public int createUser(Users user)" to do update as well by giving session.saveorUpdate
		 * (user)instead of just session.save(user) in UserDao.java*/
		
		session.save(user);
		return 1;
	}

	//We are giving any code as we have given it in createUser()
	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		return 0;
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if(user == null)
			return 0;
		session.remove(user);
		return 1;
	}

	@Override
	public int deleteUser(String emailid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Users user = session.get(Users.class, emailid);
		if(user == null)
			return 0;//Such a user doesn't exist and no deletion happened.
		session.remove(user);
		return 1;
	}

	@Override
	public Users getUserByEmailId(String emailid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Users user = session.get(Users.class, emailid);
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Users> users = session.createQuery("from Users").getResultList();
		return users;
	}

}
