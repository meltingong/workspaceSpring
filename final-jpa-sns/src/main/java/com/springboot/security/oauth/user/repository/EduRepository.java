package com.springboot.security.oauth.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.user.entity.Edu;


@Repository
public interface EduRepository extends JpaRepository<Edu, Long> {
	List<Edu> findByUserId(Long userId);
}
