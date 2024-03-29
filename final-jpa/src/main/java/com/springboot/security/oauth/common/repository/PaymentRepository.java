package com.springboot.security.oauth.common.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.common.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	List<Payment> findByUserId(long id);
	
	List<Payment> findByCorpId(long id);
}
