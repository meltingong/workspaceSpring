package com.itwill.ilhajob.blogheart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogHeartServiceImpl implements BlogHeartService {

	@Autowired
	private BlogHeartDao blogHeartDao;
	
	@Override
	public int insertHeart(int blogSeq, int userSeq) {
		return blogHeartDao.insertHeart(blogSeq, userSeq);
		
	}
	
	@Override
	public int deleteHeart(int blogSeq, int userSeq){
		return blogHeartDao.deleteHeart(blogSeq, userSeq);
	}
	
	@Override
	public int HeartCheck(int blogSeq, int userSeq){
		return blogHeartDao.HeartCheck(blogSeq, userSeq);
	}
	
	@Override
	public int updateHeartCheck(int blogSeq, int userSeq){
		return blogHeartDao.updateHeartCheck(blogSeq, userSeq);
	}
	
	@Override
	public int updateHeartCheckCancel(int blogSeq, int userSeq){
		return blogHeartDao.updateHeartCheckCancel(blogSeq, userSeq);
	}
	
}
