package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.BlogCommentDto;

public interface BlogCommentService {
	
	/*
	 * findBlogComment(블로그댓글seq로 찾기)
	 */
	BlogCommentDto findBlogComment(long id) throws Exception;
	
	/*
	 * selectAll(블로그댓글list)
	 */
	List<BlogCommentDto> selectAll();

	/* selectByBlogComment(블로그seq로 찾기)
	 */
	List<BlogCommentDto> findByBlogComment(Long blogId);
	
	/*
	 * blogComment insert
	 */
    BlogCommentDto insertBlogComment(BlogCommentDto blogComment) throws Exception;

}
