package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void categoryProductSaveAndRead() {
		
		/****case1[Many to one]***********/
		Category category = new Category("C1","컴퓨터");
		categoryRepository.save(category);
		
		Product product1 =  Product.builder().name("Excel").price(5000000).stock(100).build();
		Product product2 =  Product.builder().name("Word").price(5000000).stock(100).build();
		Product product3 =  Product.builder().name("PowerPoint").price(5000000).stock(100).build();
		
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		System.out.println("-------------------read-------------------");
		System.out.println("category:"+categoryRepository.findById(1L).get());
		System.out.println("category --> productList:"+categoryRepository.findById(1L).get().getProductList());
		/********************************/
		
		/****case2[OneToMany]************
		
		Product product1 =  Product.builder().name("Excel").price(5000000).stock(100).build();
		Product product2 =  Product.builder().name("Word").price(5000000).stock(100).build();
		Product product3 =  Product.builder().name("PowerPoint").price(5000000).stock(100).build();
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		Category category = new Category("C1","컴퓨터");
		category.getProductList().add(product1);
		category.getProductList().add(product2);
		category.getProductList().add(product3);
		
		categoryRepository.save(category);
		
		
		
		System.out.println("-------------------read-------------------");
		System.out.println("category:"+categoryRepository.findById(4L).get());
		System.out.println("category --> productList:"+categoryRepository.findById(4L).get().getProductList());
		*************************************/
	}

}
