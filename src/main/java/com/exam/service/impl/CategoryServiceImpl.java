package com.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updatecategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getcategories() {
		
		return new HashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		
		return this.categoryRepository.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categogyId) {
		
		Category category = new Category();
		category.setCid(categogyId);
		
		this.categoryRepository.delete(category);
	}

}
