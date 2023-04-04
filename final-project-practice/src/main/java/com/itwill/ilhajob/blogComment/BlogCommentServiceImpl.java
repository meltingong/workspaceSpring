package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogCommentServiceImpl implements BlogCommentService{
	
	@Autowired
	private BlogCommentDao blogCommentDao;
	
	public BlogCommentServiceImpl(BlogCommentDao blogCommentDao) {
		this.blogCommentDao=blogCommentDao;
		
	}
	
	@Override
	public BlogComment findBlogComment(int commentSeq) {
		BlogComment findBlogCommentSeq = blogCommentDao.findBlogComment(commentSeq);
		return findBlogCommentSeq;
	}
	
	@Override
	public List<BlogComment> selectAll() {
		List<BlogComment> seList = blogCommentDao.selectAll();
		return seList;
	}
	
	@Override
	public List<BlogComment> selectByBlogComment(int blogSeq) {
		List<BlogComment> selectBlogComment = blogCommentDao.selectByBlogComment(blogSeq);
		return selectBlogComment;
	}
	
	@Override
	public int insertBlogComment(BlogComment blogComment) {
		int insertCount = blogCommentDao.insertBlogComment(blogComment);
		return insertCount;
	}
	
	@Override
	public int updateBlogComment(BlogComment blogComment) {
		int updateCount = blogCommentDao.updateBlogComment(blogComment);
		return updateCount;
	}
	
	@Override
	public int deleteBlogComment(int commentSeq) {
		int deleteBlogCom = blogCommentDao.deleteBlogComment(commentSeq);
		return deleteBlogCom;
	}
	
	@Override
	public List<BlogComment>  findByUserSeqCommnt(int userSeq){
		List<BlogComment> userSeqComment = blogCommentDao.findByUserSeqCommnt(userSeq);
		return userSeqComment;
	}
}
