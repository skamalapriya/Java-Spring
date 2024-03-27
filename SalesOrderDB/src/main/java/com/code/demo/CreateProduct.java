package com.code.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.entity.Category;
import com.code.entity.Product;

@Entity
@Table(name = "products")
public class CreateProduct {  
	public CreateProduct(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Category> categories = session.createQuery("from Category").getResultList();
		Category category = categories.stream().filter(c -> c.getCategory_name().equals("Grocery")).findAny().orElse(null);
		Product pdt = new Product("Clover", "Cow's Whole Milk", 10, category);
		session.save(pdt);
		
		category = categories.stream().filter(c -> c.getCategory_name().equals("Grocery")).findAny().orElse(null);
		pdt = new Product("Orowheat", "Buttermilk Bread", 5, category);
		session.save(pdt);
		
		category = categories.stream().filter(c -> c.getCategory_name().equals("Jewellery")).findAny().orElse(null);
		pdt = new Product("Pavoi", "14K Gold Plated earring", 20, category);
		session.save(pdt);
		
		category = categories.stream().filter(c -> c.getCategory_name().equals("Dress")).findAny().orElse(null);
		pdt = new Product("Reebok", "Girl's Fleece Jacket", 30, category);
		session.save(pdt);
		
		session.getTransaction().commit();
		session.close();
	}

}
