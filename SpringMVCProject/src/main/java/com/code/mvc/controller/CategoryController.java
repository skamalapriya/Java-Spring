package com.code.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Category;
import com.code.mvc.services.ICategoryService;

@Controller
@RequestMapping(value="category/")
public class CategoryController {
	
	@Autowired
	ICategoryService categorySeviceImpl;
	
	@RequestMapping(value="add")
	public ModelAndView addCategory(Model model) {
		model.addAttribute("category", new Category());
		return new ModelAndView("category_registration", "", model);
	}
	
	@RequestMapping(value="registercategory", method = RequestMethod.POST)
	public ModelAndView register_category(@ModelAttribute("category") Category ctgry, Model model) {
		categorySeviceImpl.createCategory(ctgry);
		return new ModelAndView("redirect:/category/");
	}
	
	@RequestMapping(value="/")
	public ModelAndView listCategory(Model model) {
		List<Category> catgries = categorySeviceImpl.getAllCategories();
		System.out.println("Category objects:" + catgries);
		model.addAttribute("lstcatgries", catgries);
		return new ModelAndView("listcategory", "", model);
	}
	
	@RequestMapping(value="edit/{category_id}")
	public ModelAndView updateCategory(@PathVariable("category_id") int category_id, Model model) {
		Category catgry = categorySeviceImpl.getCategoryById(category_id);
		System.out.println("Inside update while editing category name which is " + catgry.getCategory_name());
		model.addAttribute("update_category", catgry);
		return new ModelAndView("update_category_registration", "", model);
	}
	
	@RequestMapping(value="updatecategory", method = RequestMethod.POST ,params = "register")
	public ModelAndView updateListCategory(@ModelAttribute("update_category")Category ctgry, Model model) {
		categorySeviceImpl.updateCategory(ctgry);
		return new ModelAndView("redirect:/category/");
	}
	
	@RequestMapping(value="delete/{category_id}")
	public ModelAndView deleteCategoryById(@PathVariable("category_id") int category_id, Model model) {
		categorySeviceImpl.deleteCategory(category_id);
		return new ModelAndView("redirect:/category/");
	}
	
	@RequestMapping(value="updatecategory", params = "delete")
	public ModelAndView deleteCategory(@ModelAttribute("update_category")Category ctgry, Model model) {
		categorySeviceImpl.deleteCategory(ctgry);
		return new ModelAndView("redirect:/category/");
	}
}
