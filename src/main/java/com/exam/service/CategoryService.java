package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updatecategory(Category category);
	public Set<Category> getcategories();
	public Category getCategory(Long categoryId);
	public void deleteCategory(Long categogyId);
	
}
