package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao {
	
	Blog findBlog(int blogSeq);
	
	List<Blog> selectAll();
	
	List<Blog> selectByBlogCate(int blogCateSeq);
	
	int insertBlog(Blog blog);
	
	int updateBlog(Blog blog);
	
	int deleteBlog(int blogSeq);

	List<Blog> findByUserSeqBlogList(int userSeq);
	
	List<Blog> findByBlogAndCommetAll(int blogSeq);
	
	int updateBlogReadCount(int blogSeq);
	
	int updateBlogLikeCount(int blogSeq);
	
	int updateBlogLikeDiscount(int blogSeq);
	
}
