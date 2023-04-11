package com.itwill.ilhajob.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.review.mapper.ReviewMapper;

@Repository
public class ReviewDaoImpl implements ReviewDao{
	@Autowired
	private ReviewMapper reviewMapper;
	
//	//getter
//	public ReviewMapper getReviewMapper() {
//		return reviewMapper;
//	}
//	//setter
//	public void setReviewMapper(ReviewMapper reviewMapper) {
//		this.reviewMapper = reviewMapper;
//	}
//	//constructor
//	public ReviewDaoImpl(ReviewMapper reviewMapper) {
//		this.reviewMapper=reviewMapper;
//	}

	//insert review
	@Override
	public int insertReview(Review review) throws Exception {
		return reviewMapper.insertReview(review);
	}
	//update review
	@Override
	public int updateReview(Review review) throws Exception {
		return reviewMapper.updateReview(review);
	}
	//delete review By userSeq
	@Override
	public int deleteReview(int reviewSeq) throws Exception {
		return reviewMapper.deleteByUserSeq(reviewSeq);
	}
	
	/*
	//select List By userSeq-> user mapper에서 실시할거임 
	@Override
	public List<Review> selectListByUserSeq(int userSeq) throws Exception {
		List<Review> ListByUserSeq=reviewMapper.selectReviewListByUserSeq(userSeq);
		return ListByUserSeq;
	}
	*/
		
	/*	
	//select List By corpId ->corp mapper에서 실행할거임
	}
	@Override
	public List<Review> selectListByCorpId(String corpId) throws Exception {
		return reviewMapper.selectReviewListByCorpId(corpId);
	}
	*/
		
	//existed Review 중복 체크
	@Override
	public boolean existedReview(Review review) throws Exception {
		if(reviewMapper.existedReview(review)==1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	
}
