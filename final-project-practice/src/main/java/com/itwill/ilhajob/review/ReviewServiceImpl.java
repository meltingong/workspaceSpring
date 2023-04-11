package com.itwill.ilhajob.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao=reviewDao;
	}
	
	//insert review
	@Override
	public int insertReview(Review review) throws Exception {
		return reviewDao.insertReview(review);
	}
	
	//update review
	@Override
	public int updateReview(Review review) throws Exception {
		return reviewDao.updateReview(review);
	}
	
	//delete review
	@Override
	public int deleteReview(int reviewSeq) throws Exception {
		return reviewDao.deleteReview(reviewSeq);
	}
	
	/*
	//user_seq로 작성된 리뷰 리스트 불러오기->user mapper에서 실시할거임 
	@Override
	public List<Review> selectListByUserSeq(int userSeq) throws Exception {
		return reviewDao.selectListByUserSeq(userSeq);
	}
	*/
	
	//corp_id로 작성된 리뷰 리스트 불러오기
	/*
	@Override
	public List<Review> selectListByCorpId(String corpId) throws Exception {
		return reviewDao.selectListByCorpId(corpId);
	}
	*/
	//user_seq로 같은 기업에 리뷰 중복 작성됐는지 확인
	@Override
	public boolean existedReview(Review review) throws Exception {
		boolean isExistReview=reviewDao.existedReview(review);
		if(isExistReview) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	


}
