package com.code.demo;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;

@Entity
@Table(name = "categorys")
public class CreateCategory {
	public CreateCategory(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Category category = new Category("Grocery");
		session.save(category);
		
		category = new Category("Jewellery");
		session.save(category);
		
		category = new Category("Dress");
		session.save(category);
		
		session.getTransaction().commit();
		session.close();
	}
}
