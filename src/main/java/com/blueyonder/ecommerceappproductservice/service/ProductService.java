package com.blueyonder.ecommerceappproductservice.service;

import java.util.List;
import java.util.Optional;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.entities.Product;
import com.blueyonder.ecommerceappproductservice.exceptions.ProductNotFoundException;

public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getAllProducts();
	public List<Product> getAllProductByName(String name);
	public void deleteProduct(Integer prodId) throws ProductNotFoundException;
	public Optional<Product> getProductById(Integer prodId);
//	public List<Product> getAllProductByCategory(Category category);
}