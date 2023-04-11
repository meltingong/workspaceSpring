package com.itwill.ilhajob.review;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.review.mapper")
public class SpringBootReviewDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootReviewDaoMain.class, args);
		ReviewDao reviewDao=(ReviewDao)appicationContext.getBean(ReviewDao.class);
		//System.out.println("---------Review DAO Test 시작------------------");
		//System.out.println("--insert review--");
		//Review review=new Review(6, "5", "새제목", "새내용", "corp_04", 1);
		//System.out.println(reviewDao.insertReview(review));
		//System.out.println("--update review--");
		//Review updateReview= new Review(3, "3", "수정제목", "수정내용", null, 0);
		//System.out.println(reviewDao.updateReview(updateReview));
		//System.out.println("--delete review--");
		//Review deleteReview= new Review(4, null, null, null, null, 1);
		//System.out.println(reviewDao.deleteReview(deleteReview));
		//System.out.println("--select ReviewList By UserSeq--");
		//System.out.println(reviewDao.selectListByUserSeq(2));
		//System.out.println("--select ReviewList By CorpId--");
		//System.out.println(reviewDao.selectListByCorpId("corp_01"));
		//System.out.println("--existed Review--");
		//Review isReview=new Review(0, null, null, null, "corp_01", 1);
		//System.out.println(reviewDao.existedReview(isReview));

	}

}
