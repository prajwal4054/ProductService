package com.blueyonder.ecommerceappproductservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blueyonder.ecommerceappproductservice.entities.Category;
import com.blueyonder.ecommerceappproductservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByProductName(String name);

;


}
