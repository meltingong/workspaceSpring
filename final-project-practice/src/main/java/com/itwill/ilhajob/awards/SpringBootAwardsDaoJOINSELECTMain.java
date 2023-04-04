package com.itwill.ilhajob.awards;


import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
//@MapperScan
//@MapperScan(basePackages = "com.itwill.user.mapper")
//@MapperScan(basePackageClasses =UserMapper.class)
//해당 클래스만 테스트하려고할때 기재



@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.Awards.mapper")
public class SpringBootAwardsDaoJOINSELECTMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootAwardsDaoJOINSELECTMain.class, args);
		AwardsDao awardsDao=(AwardsDao)appicationContext.getBean(AwardsDao.class);
		System.out.println("---------AwardsDaoTEST------------------");
		System.out.println(awardsDao.findAwardsList());
		System.out.println(awardsDao.findAwards(2));
		System.out.println(awardsDao.findAwardsOfUser(2));	
		Awards awards = new Awards(2, "TEST3", new Date(), "내용3", 2);
		
		//System.out.println(awardsDao.createAwards(awards));
		//System.out.println(awardsDao.removeAwards(awards));
		System.out.println(awardsDao.updateAwards(awards));

	}

}
