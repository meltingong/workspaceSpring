package com.itwill.ilhajob.corpimage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.corpimage.mapper")
public class SpringBootCorpImageDaoMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootCorpImageDaoMain.class, args);
		
		CorpImageDao corpImageDao=(CorpImageDao)appicationContext.getBean(CorpImageDao.class);
		
		System.out.println("---------selectAll------------------");
		System.out.println(corpImageDao.selectAll());
		
		System.out.println("---------selectById------------------");
		System.out.println(corpImageDao.selectById("corp_01"));
		
		System.out.println("---------selectBySEQ------------------");
		System.out.println(corpImageDao.selectBySEQ(1));
		
		System.out.println("---------insert test------------------");
		System.out.println(corpImageDao.insertCorpImage(new CorpImage(0, "default.jpg", "corp_02")));
		
		System.out.println("---------update test------------------");
		CorpImage updateCorp = corpImageDao.selectBySEQ(1);
		updateCorp.setCorpImage("default.jpg");
		System.out.println(corpImageDao.updateCorpImage(updateCorp));
		System.out.println(updateCorp.toString());
		
		
		System.out.println("---------delete test------------------");
		corpImageDao.deleteCorpImageBySEQ(8);
		
	}

}
