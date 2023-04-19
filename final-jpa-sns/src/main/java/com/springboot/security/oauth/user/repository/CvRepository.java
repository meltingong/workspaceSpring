package com.springboot.security.oauth.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.user.entity.Cv;


@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
	List<Cv> findByUserId(Long userId);
}
