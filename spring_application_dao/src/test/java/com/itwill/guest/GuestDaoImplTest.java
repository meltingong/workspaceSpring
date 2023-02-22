package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class GuestDaoImplTest {
	@Autowired
	GuestDao guestDao;
	
	@Test
	void contextLoad() {
		
	}
	
	
	@Test
	void testSelectAll() throws Exception {
		System.out.println(guestDao.selectAll());
	}
/*
	@Test
	void testSelectByNo() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertGuest() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateGuest() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteGuest() {
		fail("Not yet implemented");
	}
*/
}
