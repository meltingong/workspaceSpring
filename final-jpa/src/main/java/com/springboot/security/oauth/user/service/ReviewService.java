package com.springboot.security.oauth.user.service;

import java.util.Optional;


public interface ReviewService {
	
	//insert review
	//ReviewDto insertReview(ReviewDto reviewDto) throws Exception;
	
	//update review
	//ReviewDto updateReview(ReviewDto reviewDto) throws Exception;
	
	//delete review
	//void deleteReview(Long id) throws Exception;
	
	/*
	 * 리뷰 삭제하기
	 */
	void remove(Long reviewId) throws Exception;
	
	Long isReviewDuplicate(Long id, Long Corpid) throws Exception;
	
	
}
