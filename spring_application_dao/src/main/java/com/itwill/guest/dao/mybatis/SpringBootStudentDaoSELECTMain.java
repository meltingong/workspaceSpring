package com.itwill.guest.dao.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class SpringBootStudentDaoSELECTMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootStudentDaoSELECTMain.class, args);
		GuestDaoImplMyBatis guestDaoImplMyBatis = (GuestDaoImplMyBatis)applicationContext.getBean(GuestDaoImplMyBatis.class);
		System.out.println(guestDaoImplMyBatis.selectAll());
		System.out.println(guestDaoImplMyBatis.selectByNo(1));
	}

}
