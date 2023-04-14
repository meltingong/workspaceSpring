package com.itwill.ilhajob.common.repository;

import com.itwill.ilhajob.common.entity.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	List<Payment> findByUserId(long id);
	
	List<Payment> findByCorpId(long id);
}
