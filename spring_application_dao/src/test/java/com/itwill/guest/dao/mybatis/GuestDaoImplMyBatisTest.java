package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplMyBatisTest {
	@Autowired
	private GuestDao guestDao;
	@Disabled
	@Test
	void init() {
		
	}
	@Disabled
	@Test
	void testSelectAll() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testSelectByNo() {
		fail("Not yet implemented");
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception {
		int rowCount = guestDao.insertGuest(new Guest(0,"name","2022","email","homepage","title","context"));
		assertEquals(1,rowCount);
	}
	@Disabled
	@Test
	void testUpdateGuest() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
