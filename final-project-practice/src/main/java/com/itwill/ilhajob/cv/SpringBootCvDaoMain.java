package com.itwill.ilhajob.cv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

@MapperScan(basePackages = "com.itwill.ilhajob.cv.mapper")
public class SpringBootCvDaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootCvDaoMain.class, args);
		CvDao cvDao=(CvDao)applicationContext.getBean(CvDao.class);
		System.out.println("---------findTutorByIdWithCourses------------------");
		System.out.println(">>>>>delete ");
		System.out.println(cvDao.remove(1));

	}

}
