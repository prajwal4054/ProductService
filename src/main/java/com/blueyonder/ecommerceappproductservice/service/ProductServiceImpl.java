package com.blueyonder.ecommerceappproductservice.service;

import java.util.List;
import java.util.Optional;

import javax.naming.ldap.ControlFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.entities.Product;
import com.blueyonder.ecommerceappproductservice.exceptions.ProductNotFoundException;
import com.blueyonder.ecommerceappproductservice.repositories.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService {
	private Logger logger=LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		logger.info("Product added successfully");
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProductByName(String name) {
		// TODO Auto-generated method stub;
		return productRepository.findAllByProductName(name);
	}

	@Override
	public void deleteProduct(Integer prodId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		if(productRepository.findById(prodId)==null) logger.warn("Trying to delete a product which doesnt exist");
		productRepository.deleteById(prodId);
		
	}
	
	@Override
	public Optional<Product> getProductById(Integer prodId) {
		// TODO Auto-generated method stub
		return productRepository.findById(prodId);
	}

//	@Override
//	public List<Product> getAllProductByCategory(Category category) {
//		// TODO Auto-generated method stub
//		return productRepository.findAllByCategory(category);
//	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}


}

