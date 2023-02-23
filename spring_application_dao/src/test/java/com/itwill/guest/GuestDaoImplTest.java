package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.guest.dao.jdbc.Guest;
import com.itwill.guest.dao.jdbc.GuestDao;

@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {
	
	@Autowired
	GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(),0);
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception {
		assertNotNull(guestDao.selectByNo(1));
		assertSame(guestDao.selectByNo(1).getGuest_no(),1);
		
	}
	@Disabled
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest = new Guest(0, "테스트",null, "test@gmail.com","test.com","타이틀", "컨텐트");
		assertEquals(guestDao.insertGuest(insertGuest),1);
	}
	
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest = new Guest(1, "테스트수정",null, "testchange@gmail.com","testchange.com","타이틀수정", "컨텐트수정");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if(updateRowCount != 1) {
			fail("update 실패");
		}
	}
	
	
}
