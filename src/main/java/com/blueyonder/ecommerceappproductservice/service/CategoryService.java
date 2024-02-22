package com.blueyonder.ecommerceappproductservice.service;

import java.util.List;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.exceptions.CategoryNotFoundException;


public interface CategoryService {

	public Category addCategory(Category category);
//	public Category updateCategory(Category cateory);

	public String deleteCategory(Integer id) throws CategoryNotFoundException;

	public List<Category> getAllCategory();
}
