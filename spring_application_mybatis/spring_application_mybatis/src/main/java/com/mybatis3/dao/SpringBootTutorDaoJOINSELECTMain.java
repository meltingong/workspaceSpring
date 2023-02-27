package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;
import com.mybatis3.domain.Tutor;

@SpringBootApplication
public class SpringBootTutorDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootTutorDaoJOINSELECTMain.class, args);
		TutorDao tutorDao = (TutorDao)applicationContext.getBean(TutorDao.class);
		System.out.println("---------findTutorByIdWithAddress------------------");
		Tutor tutor = tutorDao.findTutorByIdWithCourses(1);
		System.out.println(tutor);
		System.out.println("---------findTutorByIdWithCourses------------------");
		
		System.out.println("---------findTutorByIdWithAddressWithCourses-------");
		
		
		
		
	}
}