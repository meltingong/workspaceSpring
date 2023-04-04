package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogServiceImpl() {
	}
	
	@Override
	public int insertBlog(Blog blog) {
		int insertCount = blogDao.insertBlog(blog);
		return insertCount;
	}
	
	@Override
	public int updateBlog(Blog blog) {
		int updateCount = blogDao.updateBlog(blog);
		return updateCount;
	}
	
	@Override
	public int deleteBlog(int blogSeq) {
		int deleteCount = blogDao.deleteBlog(blogSeq);
		return deleteCount;
	}
	
	@Override
	public List<Blog> selectAll(){
		List<Blog> blogList = blogDao.selectAll();
		return blogList;
	}
	
	@Override
	public List<Blog> selectByBlogCate(int blogCateSeq){
		List<Blog> blogCateList = blogDao.selectByBlogCate(blogCateSeq);
		return blogCateList;
	}
	
	@Override
	public List<Blog> findByUserSeqBlogList(int userSeq) {
		List<Blog> findByUserSeqBlogList = blogDao.findByUserSeqBlogList(userSeq);
		return findByUserSeqBlogList;
	}
	
	@Override
	public List<Blog> findByBlogAndCommetAll(int blogSeq){
		List<Blog> findByBlogAndCommetAllList = blogDao.findByBlogAndCommetAll(blogSeq);
		return findByBlogAndCommetAllList;
	}

	@Override
	public Blog findBlog(int blogSeq) {
		Blog findByBlogSeq = blogDao.findBlog(blogSeq);
		return findByBlogSeq;
	}
	
	@Override
	public int updateBlogReadCount(int blogSeq) {
		int updateReadCount = blogDao.updateBlogReadCount(blogSeq);
		return updateReadCount;
	}
	
	@Override
	public int updateBlogLikeCount(int blogSeq) {
		int updateBlogLikeCount = blogDao.updateBlogLikeCount(blogSeq);
		return updateBlogLikeCount;
	}
	
	
	@Override
	public int updateBlogLikeDiscount(int blogSeq) {
		int updateBlogLikeDiscount = blogDao.updateBlogLikeDiscount(blogSeq);
		return updateBlogLikeDiscount;
	}
}
