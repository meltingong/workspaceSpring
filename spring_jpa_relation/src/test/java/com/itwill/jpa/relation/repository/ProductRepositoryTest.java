package com.itwill.jpa.relation.repository;


import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductRepository productRepository;
	void productSaveAndUpdate() {
		Product product = Product.builder().name("JPA일주일만하면")
							.price(3000)
							.stock(100)
							.build();
		productRepository.save(product);
		product.setName("JSP하루만하면");
		productRepository.save(product);
	}
	
	@Test
	void productProductDetailSaveRead() {
		
	}
}
