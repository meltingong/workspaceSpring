package com.itwill.ilhajob.cv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.awards.AwardsDao;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.edu.EduDao;
import com.itwill.ilhajob.edu.EduService;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.exp.ExpDao;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.recruit.RecruitDao;
import com.itwill.ilhajob.user.User;

@SpringBootApplication(scanBasePackageClasses = {Cv.class, Edu.class, Awards.class, Exp.class})
@MapperScan(basePackages = {"com.itwill.ilhajob.cv.mapper"})
public class SpringBootCvDaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootCvDaoMain.class, args);
		CvDao cvDao = (CvDao)applicationContext.getBean(CvDao.class);
		EduService eduService = (EduService)applicationContext.getBean(EduService.class);
		AwardsDao awardsDao = (AwardsDao)applicationContext.getBean(AwardsDao.class);
		EduDao eduDao = (EduDao)applicationContext.getBean(EduDao.class);
		ExpDao expDao = (ExpDao)applicationContext.getBean(ExpDao.class);
//		AppDao appDao = (AppDao)applicationContext.getBean(AppDao.class);
		
//		System.out.println(cvDao.findCvListByUserSeq(1));
//		System.out.println(cvDao.findCvListByUserSeq(2));
//		System.out.println(cvDao.findCvListByUserSeq(3));
		
//		System.out.println(awardsDao.findAwardsList());
//		System.out.println(eduDao.selectAllEdu());
//		System.out.println(expDao.selectByUser(3));
//		System.out.println("---------findTutorByIdWithCourses------------------");
//		System.out.println(">>>>>delete ");
//		System.out.println(cvDao.remove(1));
//		System.out.println(cvDao.selectAll());
//		
//		System.out.println(cvDao.findCvListByUserSeq(3));
//		System.out.println(cvDao.detailCv(2));
//		System.out.println("=============================================");
//		System.out.println(eduService.selectAllEdu());
//		System.out.println("--한 회사가 올린 공고 하나의 이력서 목록 불러오기:findCvListByCorpId--");
//		System.out.println(cvDao.findCvListByCorpId("corp_01"));
	}

}
