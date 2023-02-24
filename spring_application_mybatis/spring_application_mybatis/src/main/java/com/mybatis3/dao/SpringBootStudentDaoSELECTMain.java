package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoSELECTMain.class, args);
		StudentDao studentDao =(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println(studentDao);
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(1));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("---------findStudentNameById-------------------------");
		
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		
		
	}
}
