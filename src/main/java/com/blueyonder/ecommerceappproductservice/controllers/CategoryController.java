package com.blueyonder.ecommerceappproductservice.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerceappproductservice.service.CategoryService;


@CrossOrigin("*")
@RestController
@RequestMapping("/ecommerceapp/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add-category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category c=categoryService.addCategory(category);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
//	@PostMapping("/category/{id}")
//	public ResponseEntity<Category>updateCategory(@RequestBody Category category){
//		Category c=categoryService.updateCategory(category);
//		return new ResponseEntity<>(c,HttpStatus.CREATED);
//	}
	
	@PostMapping("/deletecategory")
	public ResponseEntity<String> deleteCategory(@RequestParam("id") Integer id) throws CategoryNotFoundException{
		String s=categoryService.deleteCategory(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
		
	}
	@GetMapping("/categories")
	public ResponseEntity<List<Category>>getAllCategory(){
		List<Category>list=categoryService.getAllCategory();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
