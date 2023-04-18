package com.springboot.security.oauth.corp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.corp.entity.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
	List<Manager> findByCorpId(Long corpId);
	
}
