package com.springboot.security.oauth.corp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.corp.entity.CorpImage;


public interface CorpImageRepository extends JpaRepository<CorpImage, Long> {
	
	List<CorpImage> findByCorpId(long id);

}
