package com.itwill.ilhajob.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.edu.mapper")
public class SpringBootEduDaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootEduDaoMain.class, args);
		//EduDao eduDao = (EduDao)applicationContext.getBean(EduDao.class);
//		System.out.println("------ EduDaoTest-----");
//		System.out.println(eduDao.insertEdu(new Edu(0, "영문학과", "서울대학교", new Date(), new Date(), 3.45, "학력 설명", 3)));
//		System.out.println(eduDao.selectAllEdu());
//		System.out.println(eduDao.selectEduByUserSeq(3));
//		Edu updateEdu = new Edu(9, "수학과", "고려대학교", new Date(), new Date(), 4.1, "수학과 졸업", 2);
//		System.out.println(eduDao.updateEdu(updateEdu));
//		System.out.println(eduDao.deleteEduByEduSeq(8));
//		System.out.println(eduDao.deleteAllEdu(3));
		
//		EduService eduService = (EduService)applicationContext.getBean(EduService.class);
//		System.out.println("------ EduServiceTest-----");
//		System.out.println(eduService.insertEdu(new Edu(0, "건축학과", "성균관대학교 일반대학원", new Date(), new Date(), "3.2", "석사졸업", 2)));
//		System.out.println(eduService.deleteEduByEduSeq(5));
//		System.out.println(eduService.selectAllEdu());
//		System.out.println(eduService.selectEduByUserSeq(2));
	}

}
