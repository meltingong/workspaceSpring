package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoJOINSELECTMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println("---------findStudentByIdWithAddressWithCourses-------");
		
		
		
		
	}
}