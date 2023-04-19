package com.springboot.security.oauth.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.user.entity.Exp;


@Repository
public interface ExpRepository extends JpaRepository<Exp, Long> {
	List<Exp> findByUserId(Long userId);
}
