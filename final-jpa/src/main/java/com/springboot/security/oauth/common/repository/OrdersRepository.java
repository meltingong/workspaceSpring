package com.springboot.security.oauth.common.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.common.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	List<Orders> findByUserId(long id);
	List<Orders> findByCorpId(long id);
}
