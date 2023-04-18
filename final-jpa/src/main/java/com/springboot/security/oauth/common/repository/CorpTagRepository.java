package com.springboot.security.oauth.common.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.common.entity.CorpTag;

public interface CorpTagRepository extends JpaRepository<CorpTag, Long>{

	public List<CorpTag> findByCorpId(Long id);
}
