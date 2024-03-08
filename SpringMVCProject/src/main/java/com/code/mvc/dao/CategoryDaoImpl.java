package com.code.mvc.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.mvc.entity.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
		return 1;
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		return 1;
	}

	@Override
	public int deleteCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if(category == null)
			return 0;
		session.remove(category);
		return 1;
	}

	@Override
	public int deleteCategory(int category_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, category_id);
		if(category == null)
			return 0;
		session.remove(category);
		return 1;
		
	}

	@Override
	public Category getCategoryById(int category_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, category_id);
		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category").getResultList();
		return categories;
	}

	@Override
	public Category search(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category searchCategoryByChars(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
