package com.itwill.jpa.relation.repository;


import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductDetailRepository productDetailRepository;
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
		Product product = new Product();
		product.setName("스프링 시큐리티");
		product.setPrice(80000);
		product.setStock(500);
		productRepository.save(product);
		
		
		 ProductDetail productDetail = new ProductDetail();
		 productDetail.setDescription("아주 좋은 책이에요");
		 productDetail.setProduct(product);
		 
		 productDetailRepository.save(productDetail);
		 
		 System.out.println("-----------------read------------------");
		 ProductDetail productDetail2 = productDetailRepository.findById(2L).get();
		 Product product2 = productDetailRepository.findById(2L).get().getProduct();
		 System.out.println(">>productDetail:"+productDetail2);
		 System.out.println(">>product:"+product2);
	}
}
