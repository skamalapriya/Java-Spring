package com.code.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvc.dao.ICategoryDao;
import com.code.mvc.entity.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	ICategoryDao categoryDaoImpl;
	@Override
	public int createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDaoImpl.createCategory(category);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDaoImpl.updateCategory(category);
	}

	@Override
	public int deleteCategory(int category_id) {
		// TODO Auto-generated method stub
		return categoryDaoImpl.deleteCategory(category_id);
	}

	@Override
	public int deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDaoImpl.deleteCategory(category);
	}

	@Override
	public Category getCategoryById(int category_id) {
		// TODO Auto-generated method stub
		return categoryDaoImpl.getCategoryById(category_id);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDaoImpl.getAllCategories();
	}

	@Override
	public Category searchCategory(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> searchCategoryByChars(String category_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
