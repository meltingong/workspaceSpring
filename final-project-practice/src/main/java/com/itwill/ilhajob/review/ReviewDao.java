package com.itwill.ilhajob.review;

import java.util.List;

public interface ReviewDao {
	
	//insert review
	int insertReview(Review review) throws Exception;
	
	//update review
	int updateReview(Review review) throws Exception;
	
	//delete review
	int deleteReview(int reviewSeq) throws Exception;
	
	//user_seq로 user가 쓴 리뷰 목록 불러오기-> user mapper에서 실시할거임 
	//List<Review> selectListByUserSeq(int userSeq) throws Exception;
	
	//corp_id로 해당 기업의 리뷰 목록 불러오기->corp mapper에서 실행할거임
	//List<Review> selectListByCorpId(String corpId) throws Exception;
	
	//user 1명이 기업 1에 리뷰 중복 작성 안됨: 중복 체크
	boolean existedReview(Review review) throws Exception;
	
	
}
