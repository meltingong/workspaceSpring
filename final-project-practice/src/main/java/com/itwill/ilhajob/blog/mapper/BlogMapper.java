package com.itwill.ilhajob.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.blog.Blog;

@Mapper
public interface BlogMapper {

	public int insertBlog(Blog blog);
	public int updateBlog(Blog blog);
	public int deleteBlog(int blogSeq);

	public Blog findBlog(int blogSeq);
	
	public List<Blog> selectAll();
	public List<Blog> selectByBlogCate(int blogCateSeq);
	public List<Blog> findByUserSeqBlogList(int userSeq);
	public List<Blog> findByBlogAndCommetAll(int blogSeq);
	
	public int updateBlogReadCount(int blogSeq);
	
	public int updateBlogLikeCount(int blogSeq);
	public int updateBlogLikeDiscount(int blogSeq);
	
}