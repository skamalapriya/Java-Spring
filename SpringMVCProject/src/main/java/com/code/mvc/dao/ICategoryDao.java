package com.code.mvc.dao;

import java.util.List;

import com.code.mvc.entity.Category;

public interface ICategoryDao {
	public int createCategory(Category category);
	public int updateCategory(Category category);
	public int deleteCategory(Category category);
	public int deleteCategory(int category_id);
	public Category getCategoryById(int category_id);
	public List<Category> getAllCategories();
	public Category search(String category_name);
	public Category searchCategoryByChars(String category_name);
	
}
