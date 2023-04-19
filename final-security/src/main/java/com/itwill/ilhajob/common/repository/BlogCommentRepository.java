package com.itwill.ilhajob.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.common.entity.BlogComment;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long>{

	List<BlogComment> findByBlogId(Long blogId);
}
