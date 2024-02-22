package com.blueyonder.ecommerceappproductservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blueyonder.ecommerceappproductservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query(value="select * from user_info u where u.user_name=?1",nativeQuery = true)
	public Category updateCategory(Category category);
	@Query(value="DELETE from category_info WHERE category_id =?1 RETURNING *",nativeQuery = true)
	public void deleteCategory(Integer id);
	
}
