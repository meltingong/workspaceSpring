package com.itwill.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByName(String name);
}
