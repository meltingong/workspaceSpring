package com.itwill.ilhajob.corp;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(basePackages = {"com.itwill.ilhajob.corp.mapper","com.itwill.ilhajob.product.mapper"})
public class SpringBootCorpDaoMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCorpDaoMain.class, args);
		
//		CorpDao corpDao=(CorpDao)appicationContext.getBean(CorpDao.class);
		/*
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(corpDao.selectAll());
		System.out.println("---------selectById------------------");
		System.out.println(corpDao.selectById("corp_01"));
		System.out.println("---------findCorpByIdWithCorpImage------------------");
		System.out.println(corpDao.findCorpByIdWithAll("corp_01"));
		System.out.println("---------findCorpByIdWithCorpImage------------------");
		System.out.println(corpDao.findCorpByIdWithOrders("corp_01"));
		*/
		
		
		/*
		System.out.println("---------findCorpByIdWithRecruit------------------");
		System.out.println(corpDao.findCorpByIdWithRecruit("corp_01"));
		
//		System.out.println("------------insertCorp---------------");
//		System.out.println(corpDao.insertCorp(
//				Corp.builder()
//				.corpId("testDao@test.com")
//				.corpPassword("tttt")
//				.corpName("testDao")
//				.build())
//		);
		System.out.println("------------updateCorp---------------");
		Corp updateCorp = corpDao.selectById("기업1@corp.com");
		updateCorp.setCorpPassword("1122");
		updateCorp.setCorpName("테스트기업1수정");
		updateCorp.setCorpPhone("02-tttt-수정");
		updateCorp.setCorpBusinessNo("ttt-tt-ttttt");
		updateCorp.setCorpWebsite("http://www.ttt.com");
		updateCorp.setCorpEst(new Date());
		updateCorp.setCorpSize("100명");
		updateCorp.setCorpSales("ttt억");
		updateCorp.setCorpComment("수정완료");
		updateCorp.setCorpWelfare("수정복지완료");
		updateCorp.setCorpAddress("주소업데이트");
		updateCorp.setCorpStatus('F');
		updateCorp.setJob("g");
		updateCorp.setRole(1);
		System.out.println(corpDao.updateCorp(updateCorp));
		
		System.out.println("------------deleteCorp---------------");
		Corp deleteCorp = corpDao.selectById("기업1@corp.com");
		System.out.println("Delete >>> "+deleteCorp);
		System.out.println(corpDao.deleteCorp(deleteCorp));
		
		
		System.out.println("------------insert test---------------");
		System.out.println(corpDao.insertCorp(
				Corp.builder()
				.corpId("testDao@test.com")
				.corpPassword("tttt")
				.corpName("testDao")
				.build())
		);

		System.out.println("-------------existedCorp--------------");
		System.out.println(corpDao.existedCorp("corp_00"));
		System.out.println(corpDao.existedCorp("corp_01"));
		 */
		
//		System.out.println("--findCorpByIdWithReview--");
//		System.out.println(corpDao.findCorpByIdWithReview("corp_01"));

	}

}
