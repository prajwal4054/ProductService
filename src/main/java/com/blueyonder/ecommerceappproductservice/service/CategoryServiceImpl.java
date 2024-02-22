package com.blueyonder.ecommerceappproductservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerceappproductservice.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private Logger logger=LoggerFactory.getLogger(CategoryService.class);
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		logger.info("Category added successfully");
		categoryRepository.save(category);
		return category;
	}

	@Override
	public String deleteCategory(Integer id) throws CategoryNotFoundException {
		if(categoryRepository.findById(id)!=null) {
			logger.warn("Trying to delete non existence category");
			categoryRepository.deleteCategory(id);
			return "Category with id "+id + " is deleted";
		}
		throw new CategoryNotFoundException();
		
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
