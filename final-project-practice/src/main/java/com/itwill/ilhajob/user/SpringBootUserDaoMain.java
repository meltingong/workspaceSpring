package com.itwill.ilhajob.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootUserDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootUserDaoMain.class, args);
		UserDao userDao=(UserDao)appicationContext.getBean(UserDao.class);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		//System.out.println("---------findUserByIdWithReview------------------");
		//System.out.println(userDao.findUserByIdWithReview(1));

	}

}
;