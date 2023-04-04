package com.itwill.ilhajob.exp;

import java.sql.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.exp.mapper")
public class SpringBootExpDaoMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootExpDaoMain.class, args);
		ExpDao expDao=(ExpDao)appicationContext.getBean(ExpDao.class);
		//System.out.println(">>> userSeq로 Exp전체 찾기");
		//System.out.println(expDao.selectByUser(2));
		/*
		System.out.println(">>> 경력 추가");
		Exp newExp = new Exp(0,"개발자","넥슨",new Date(2020/06/10),new Date(2023/01/25),"게임개발 업무를 주로 하였으며 서든어택 개발참여",1);
		System.out.println(expDao.insertExp(newExp));
		System.out.println(">>> 경력 업데이트");
		Exp updateExp = new Exp(8,"개발팀장","넥슨",new Date(2020/06/10),new Date(2023/01/25),"게임개발 업무를 주로 하였으며 서든어택 개발참여",1);
		System.out.println(expDao.updateExp(updateExp));
		*/
		//System.out.println(">>>경력 삭제");
		//System.out.println(expDao.deleteExp(8));

	}

}
