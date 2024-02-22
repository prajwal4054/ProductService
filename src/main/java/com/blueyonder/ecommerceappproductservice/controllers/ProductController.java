package com.blueyonder.ecommerceappproductservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.entities.Product;
import com.blueyonder.ecommerceappproductservice.exceptions.ProductNotFoundException;
import com.blueyonder.ecommerceappproductservice.service.ProductService;
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product prod = productService.addProduct(product);
		return new ResponseEntity<>(prod,HttpStatus.CREATED);
		
	}
	
//	@GetMapping(value="/productbycategory")
//	public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam("category") Category category) throws ProductNotFoundException{
//		List<Product> products = productService.getAllProductByCategory(category);
//		if(!products.isEmpty())
//		{
//			return new ResponseEntity<>(
//					products,
//					HttpStatus.OK);
//		}else {
//			throw new ProductNotFoundException();
//		}
		
		
//	}
	
	@GetMapping (value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products =  productService.getAllProducts();
        if(!products.isEmpty()) {
        	return new ResponseEntity<>(
        			products,
        			HttpStatus.OK);
        }
        return new ResponseEntity<>(
        		HttpStatus.NOT_FOUND);       
    }
	
	@GetMapping(value = "/productbyid")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Integer id){
		Optional<Product> p=productService.getProductById(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/productsbyname")
	public ResponseEntity<List<Product>> getAllProductsbyName(@RequestParam("name") String name){
		List<Product> products = productService.getAllProductByName(name);
		if(!products.isEmpty()) {
			return new ResponseEntity<>(
					products,
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				products,
				HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/deleteproduct")
	public void deleteProduct(@RequestParam("id") Integer prodId) throws ProductNotFoundException{
		if(productService.getProductById(prodId)==null) {
			throw new ProductNotFoundException();
		}
		productService.deleteProduct(prodId);
		
	}
	
	
	
}
