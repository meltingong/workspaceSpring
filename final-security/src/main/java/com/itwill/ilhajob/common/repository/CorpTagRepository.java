package com.itwill.ilhajob.common.repository;

import com.itwill.ilhajob.common.entity.CorpTag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpTagRepository extends JpaRepository<CorpTag, Long>{

	public List<CorpTag> findByCorpId(Long id);
	
	public List<CorpTag> findByTagId(Long tagId);
}
