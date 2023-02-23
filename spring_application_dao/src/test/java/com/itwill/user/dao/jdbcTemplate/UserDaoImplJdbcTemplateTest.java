package com.itwill.user.dao.jdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
@SpringBootApplication
@SpringBootTest
class UserDaoImplJdbcTemplateTest {
	@Autowired
	UserDao userDao;
	@Disabled
	@Test
	void testCreate() throws Exception {
		User user = new User("스타벅스","1111","하","후");
		try {
			int rowCount = userDao.create(user);
			assertEquals(rowCount, 1);
		}catch (Exception e) {
			//fail(e.getMessage());
			assertInstanceOf(SQLIntegrityConstraintViolationException.class, e);
			//assertInstanceOf(DuplicateKeyException.class, e);
		}
	}
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFindUser() throws Exception {
		System.out.println(userDao.findUser("guard1"));
	}
	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
