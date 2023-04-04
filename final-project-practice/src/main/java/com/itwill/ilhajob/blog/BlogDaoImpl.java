package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blog.mapper.BlogMapper;

@Repository
public class BlogDaoImpl implements BlogDao {
	@Autowired
	private BlogMapper blogMapper;
	

	public Blog findBlog(int blogSeq) {
		return blogMapper.findBlog(blogSeq);
	}
	
	public List<Blog> selectAll() {
		return blogMapper.selectAll();
	}
	
	public List<Blog> selectByBlogCate(int blogCateSeq) {
		return blogMapper.selectByBlogCate(blogCateSeq);
	}
	
	public List<Blog> findByBlogAndCommetAll(int blogSeq){
		return blogMapper.findByBlogAndCommetAll(blogSeq);
	}
	
	public int insertBlog(Blog blog) {
		return blogMapper.insertBlog(blog);
	}
	
	public int updateBlog(Blog blog) {
		return blogMapper.updateBlog(blog);
	}
	
	public int deleteBlog(int blogSeq) {
		return blogMapper.deleteBlog(blogSeq);
	}
	
	public List<Blog> findByUserSeqBlogList(int userSeq) {
		return blogMapper.findByUserSeqBlogList(userSeq);
	}
	
	public int updateBlogReadCount(int blogSeq) {
		return blogMapper.updateBlogReadCount(blogSeq);
	}
	
	public int updateBlogLikeCount(int blogSeq) {
		return blogMapper.updateBlogLikeCount(blogSeq);
	}
	
	public int updateBlogLikeDiscount(int blogSeq) {
		return blogMapper.updateBlogLikeDiscount(blogSeq);
	}
}