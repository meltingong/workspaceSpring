package com.itwill.ilhajob.recruitTag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.recruitTag.mapper")
public class SpringBootRecruitTagDaoMain{
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootRecruitTagDaoMain.class, args);
		
		RecruitTagDao recruitTagDao=(RecruitTagDao)appicationContext.getBean(RecruitTagDao.class);
		/*
		System.out.println("---------insert------------------");
		System.out.println(recruitTagDao.insertRecruitTag(RecruitTag.builder().rcSeq(3).tagId(2).build()));
		System.out.println("---------selectRecruitByTag------------------");
		System.out.println(recruitTagDao.selectRecruitByTag(1));
		System.out.println("---------existedCorpTag------------------");
		System.out.println(recruitTagDao.existedRecruitTag(2, 3));
		System.out.println("---------deleteCorpTag------------------");
		System.out.println(recruitTagDao.deleteRecruitTag(2, 3));
		 */
	}

}
