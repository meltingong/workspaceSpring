package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GuestDaoImplJdbcTempleteTest {
	
	@Autowired
	GuestDao guestDao;
	
	@Test
	void testSelectAll() throws Exception {
		assertNotNull(guestDao.selectAll());
		assertEquals(guestDao.selectAll().size(),17);
		System.out.println(guestDao.selectAll());
	}
	
	@Disabled
	@Test
	void testSelectByNo() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testInsertGuest() {
		fail("Not yet implemented");
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
