package com.itwill.ilhajob.review;

import java.util.List;

public interface ReviewService {
	
	//insert review
	int insertReview(Review review) throws Exception;
	
	//update review
	int updateReview(Review review) throws Exception;	
	
	//delete review
	int deleteReview(int reviewSeq) throws Exception;
	
	//user_seq로 작성된 리뷰 리스트 불러오기 ->user mapper에서 실시할거임 
	//List<Review> selectListByUserSeq(int userSeq) throws Exception;
	
	//corp_id로 작성된 리뷰 리스트 불러오기
	//List<Review> selectListByCorpId(String corpId) throws Exception;
	
	//user_seq로 같은 기업에 리뷰 중복 작성됐는지 확인
	boolean existedReview(Review review) throws Exception;
}
