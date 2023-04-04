package com.itwill.ilhajob.blogheart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.blogHeart.mapper")
public class SpringBootBlogHeartDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootBlogHeartDaoMain.class, args);
	
		BlogHeartDao blogHeartDao=(BlogHeartDao)appicationContext.getBean(BlogHeartDao.class);
		
		System.out.println("--------insertHeart--------");
		//blogHeartDao.insertHeart(2, 3);
		
		System.out.println("--------deleteHeart--------");
		//blogHeartDao.deleteHeart(3, 1);
		
		System.out.println("--------HeartCheck--------");
		//System.out.println(blogHeartDao.HeartCheck(1,1));

		
		System.out.println("--------updateHeartCheck--------");
		//blogHeartDao.updateHeartCheck(1, 1);
	
		System.out.println("--------updateHeartCheckCancel--------");
		//blogHeartDao.updateHeartCheckCancel(1, 1);
		
	}
}