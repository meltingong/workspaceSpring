package com.itwill.ilhajob.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.review.Review;

@Mapper
public interface ReviewMapper {
	
	//insert review
	public int insertReview(Review review) throws Exception;
	
	//update review
	public int updateReview(Review review) throws Exception;
	
	//user_seq 사용해서 delete review
	public int deleteByUserSeq(int reviewSeq) throws Exception;
	
	//user_seq로 user가 쓴 리뷰 목록 불러오기-> user mapper에서 실시할거임 
	//public List<Review> selectReviewListByUserSeq(int userSeq) throws Exception;
	
	//corp_id로 해당 기업의 리뷰 목록 불러오기->corp mapper에서 실행할거임
	//public List<Review> selectReviewListByCorpId(String corpId) throws Exception;
	
	//user 1명이 기업 1에 리뷰 중복 작성 안됨: 중복 체크 
	public int existedReview(Review review) throws Exception;
}
