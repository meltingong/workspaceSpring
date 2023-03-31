package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.Provider;

class ProviderRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void providerProductSaveRead() {
			
			Provider provider=newProvider("오릴리출판사");
			
			providerRepository.save(provider);
			
			Product product1=newProduct("파이썬", 10000, 100);
			Product product2=newProduct("머신러닝", 30000, 300);
			Product product3=newProduct("인공지능", 89000, 50);
		
			/*****연관설정 Product-->Provider*****/
			product1.setProvider(provider);
			product2.setProvider(provider);
			product3.setProvider(provider);
			
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product2);
			
			
			System.out.println("Provider:"+providerRepository.findById(1L).get());
			System.out.println("Provider --> ProductList:"+providerRepository.findById(1L).get().getProductList());
			
	}
	
	private Provider newProvider(String name) {
		Provider provider=new Provider(name);
		return provider;
	}
	private Product newProduct(String name,Integer price,Integer stock) {
		Product product=new Product(name,price,stock);
		return product;
	}
}
