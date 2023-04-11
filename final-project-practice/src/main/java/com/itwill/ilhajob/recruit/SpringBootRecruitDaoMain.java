package com.itwill.ilhajob.recruit;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.itwill.ilhajob.corp","com.itwill.ilhajob.recruit"})
//@MapperScan(basePackages = "com.itwill.ilhajob.Awards.mapper")
public class SpringBootRecruitDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootRecruitDaoMain.class, args);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		RecruitService recruitService=(RecruitService)appicationContext.getBean(Recruit.class);
		System.out.println("---------마감일 테스트----------");
		Date rcDeadLine=null;
		System.out.println(">>>>>>>>>>>>>>>>>"+recruitService.getStatus(rcDeadLine));
		System.out.println();

	}

}
