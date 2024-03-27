package com.code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.User;

public class CreateUser {
	public CreateUser(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User user = new User("Priya", "priya@abc.com", "priyadob286");
		session.save(user);
		
		user = new User("Selva", "selva@abc.com", "selva@82");
		session.save(user);
		
		user = new User("Gopi", "gopi@abc.com", "gopi@12");
		session.save(user);
		
		user = new User("Aruni", "aruni@abc.com", "aruni@14");
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
