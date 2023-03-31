package com.itwill.jpa.relation.repository;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;
import com.itwill.jpa.relation.entity.Provider;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProviderRepository providerRepository;
	
	//@Test
	void productSaveAndUpdate() {
		Product product = Product.builder().name("JPA일주일만하면")
							.price(3000)
							.stock(100)
							.build();
		productRepository.save(product);
		product.setName("JSP하루만하면");
		productRepository.save(product);
	}
	
	//@Test
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
	
	@Test
	void productProviderSaveRead() {
		
		Provider provider = new Provider();
		provider.setName("삼성출판사");
		providerRepository.save(provider);
		
		Product product1 = new Product();
		product1.setName("삼성책");
		product1.setPrice(9000);
		product1.setStock(100);
		
		
		Product product2 = new Product();
		product2.setName("수학책");
		product2.setPrice(15000);
		product2.setStock(12);
		
		/******연관설정 product --> provider*/
		product1.setProvider(provider);
		product2.setProvider(provider);
		/************************************/
		productRepository.save(product1);
		productRepository.save(product2);
		
		/******연관설정 provider --> product *****/
		//Provider provider2 = providerRepository.findById(1L).get();
		//provider2.getProductList().addAll(Arrays.asList(product1,product2));
		
		providerRepository.save(provider);
		
		System.out.println(">>>>Product:"+productRepository.findById(2L).get());
		System.out.println(">>>>Product --- > Provider:"+productRepository.findById(2L).get().getProvider());
		System.out.println(">>>>Product --- > Provider --> productList:"+productRepository.findById(2L).get().getProvider().getProductList());
		
		
	}
	
}
