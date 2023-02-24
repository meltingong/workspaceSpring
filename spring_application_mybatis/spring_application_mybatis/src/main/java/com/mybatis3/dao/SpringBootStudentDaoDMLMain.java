package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) throws ParseException {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(10000,"만두","dumpling@gmail.com",new Date());
		System.out.println("###insert rowCount :"+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0,"멍청이","stupid@gmail.com",new Date());
		System.out.println("###insert rowCount :"+studentDao.insertStudentBySequence1(student2));
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3 = new Student(0,"하하하","haha@gmail.com",new Date());
		System.out.println("###insert rowcount :"+studentDao.insertStudentBySequence2(student3));
		System.out.println("### pk-->"+student3.getStudId());
		System.out.println("###"+student3.getStudId()+"번 pk student:"+studentDao.findStudentById(student3.getStudId()));
		System.out.println("---------updateStudentById---------------------------");
		Student updateStudent = new Student(student3.getStudId(),"후후후","huhu@gmail.com",new Date());
		System.out.println("###update rowcount :"+studentDao.updateStudentById(updateStudent));
		Student updateStudent2 = studentDao.findStudentById(3);
		updateStudent2.setName("이민호");
		updateStudent2.setEmail("minho@gmail.com");
		updateStudent2.setDob(new SimpleDateFormat("yyyy/MM/dd").parse("2020/12/15"));
		System.out.println("###update rowCount :"+studentDao.updateStudentById(updateStudent2));
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("###delete rowCount :"+studentDao.deleteStudentById(9));
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("###delete rowCount :"+studentDao.deleteStudentByName("만두"));
		System.out.println("---------deleteStudentByNameLike---------------------");
		
		
	}
}
