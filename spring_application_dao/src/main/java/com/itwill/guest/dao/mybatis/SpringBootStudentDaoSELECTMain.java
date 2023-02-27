package com.itwill.guest.dao.mybatis;

import java.sql.Date;

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
		Guest insertGuest = new Guest(0,"Test","2023/12/04","Test","Test","Test","Test");
		System.out.println(guestDaoImplMyBatis.insertGuest(insertGuest));
		System.out.println(guestDaoImplMyBatis.updateGuest(new Guest(1,"update","2022-12-04","update","update","update","update")));
		System.out.println(guestDaoImplMyBatis.deleteGuest(insertGuest.getGuest_no()));
	}

}
