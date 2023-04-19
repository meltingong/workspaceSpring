package com.springboot.security.oauth.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.common.entity.BlogComment;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long>{

}
