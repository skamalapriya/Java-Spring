package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.Category;

public interface ICategoryService {
	public int createCategory(Category category);
	public int updateCategory(Category category);
	public int deleteCategory(int category_id);
	public int deleteCategory(Category category);
	public Category getCategoryById(int category_id);
	public List<Category> getAllCategories();
	public Category searchCategory(String category_name);
	public List<Category> searchCategoryByChars(String category_name);
}
