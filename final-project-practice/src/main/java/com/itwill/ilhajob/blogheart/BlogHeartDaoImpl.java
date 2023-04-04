package com.itwill.ilhajob.blogheart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.blogheart.mapper.BlogHeartMapper;

@Repository
public class BlogHeartDaoImpl implements BlogHeartDao  {

	@Autowired
	private BlogHeartMapper blogHeartMapper;

	@Override
	public int insertHeart(int blogSeq, int userSeq){
		return blogHeartMapper.insertHeart(blogSeq, userSeq);
		
	}

	@Override
	public int deleteHeart(int blogSeq, int userSeq) {
		return blogHeartMapper.deleteHeart(blogSeq, userSeq);
	}
	
	@Override
	public int HeartCheck (int blogSeq, int userSeq){
		return blogHeartMapper.HeartCheck(blogSeq, userSeq);
	}
	
	
	@Override
	public int updateHeartCheck(int blogSeq, int userSeq) {
		return blogHeartMapper.updateHeartCheck(blogSeq, userSeq);
		
	}
	
	@Override
	public int updateHeartCheckCancel(int blogSeq, int userSeq){
		return blogHeartMapper.updateHeartCheckCancel(blogSeq, userSeq);
	}
	
}
