package com.itwill.ilhajob.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.itwill.ilhajob.user","com.itwill.ilhajob.message"})
//(scanBasePackages = {"com.itwill.ilhajob.user","com.itwill.ilhajob.app"})
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootUserDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootUserDaoMain.class, args);
		UserDao userDao=(UserDao)appicationContext.getBean(UserDao.class);
		//Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);
		//System.out.println("---------findUserByIdWithReview------------------");
		//System.out.println(userDao.findUserByIdWithReview(1));
		//userDao.update(new User(0,"test4@test.com","4444","김사원",null,null,null,null,35,null,null,null,null,null,null,null,null,1,null,null,null,null,null));
		
	}

}
;