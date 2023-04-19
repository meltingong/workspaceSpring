package com.itwill.ilhajob.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.ilhajob.common.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{

	@Modifying
	@Query("update Blog b set b.blogReadCount = b.blogReadCount + 1 where b.id = :id")
	int updateViews(@Param("id") Long id);
	
	
}
