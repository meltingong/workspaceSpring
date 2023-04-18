package com.springboot.security.oauth.common.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.common.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByproductDiv(String div);
}
