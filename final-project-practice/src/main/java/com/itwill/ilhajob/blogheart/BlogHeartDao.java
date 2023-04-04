package com.itwill.ilhajob.blogheart;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogHeartDao {


	int deleteHeart(int blogSeq, int userSeq);

	int HeartCheck(int blogSeq, int userSeq);

	int updateHeartCheck(int blogSeq, int userSeq);

	int updateHeartCheckCancel(int blogSeq, int userSeq);

	int insertHeart(int blogSeq, int userSeq);


	

	

}