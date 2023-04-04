package com.itwill.ilhajob.blogComment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blogComment.mapper.BlogCommentMapper;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	private BlogCommentMapper blogCommentMapper;
	
	@Override
	public BlogComment findBlogComment(int commentSeq) {
		return blogCommentMapper.findBlogComment(commentSeq);
	}
	
	@Override
	public List<BlogComment> selectAll() {
		return blogCommentMapper.selectAll();
	}
	
	@Override
	public List<BlogComment> selectByBlogComment(int blogSeq) {
		return blogCommentMapper.selectByBlogComment(blogSeq);
	}
	
	@Override
	public int insertBlogComment(BlogComment blogComment) {
		return blogCommentMapper.insertBlogComment(blogComment);
	}
	
	@Override
	public int updateBlogComment(BlogComment blogComment) {
		return blogCommentMapper.updateBlogComment(blogComment);
	}
	
	@Override
	public int deleteBlogComment(int commentSeq) {
		return blogCommentMapper.deleteBlogComment(commentSeq);
	}
	
	@Override
	public List<BlogComment>findByUserSeqCommnt(int userSeq) {
		return blogCommentMapper.findByUserSeqCommnt(userSeq);
	}
}