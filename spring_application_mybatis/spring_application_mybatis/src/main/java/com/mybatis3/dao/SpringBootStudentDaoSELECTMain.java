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
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootStudentDaoSELECTMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootStudentDaoSELECTMain.class, args);
		StudentDao studentDao =(StudentDao)applicationContext.getBean(StudentDao.class);
		System.out.println(studentDao);
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(studentDao.findStudentById(1));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(studentDao.findAllStudents());
		System.out.println("---------findStudentNameById-------------------------");
		System.out.println(studentDao.findStudentNameById(2));
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println(studentDao.findStudentNameList());
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		
		
	}
}
