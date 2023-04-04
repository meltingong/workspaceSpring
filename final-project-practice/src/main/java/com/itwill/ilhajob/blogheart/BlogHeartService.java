package com.itwill.ilhajob.blogheart;


public interface BlogHeartService {


	int deleteHeart(int blogSeq, int userSeq);
	
	int HeartCheck(int blogSeq, int userSeq);

	int updateHeartCheck(int blogSeq, int userSeq);

	int updateHeartCheckCancel(int blogSeq, int userSeq);

	int insertHeart(int blogSeq, int userSeq);

	
	
}