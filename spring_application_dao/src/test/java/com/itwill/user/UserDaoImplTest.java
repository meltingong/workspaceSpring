package com.itwill.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@SpringBootTest
class UserDaoImplTest {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	UserDao userDao;
	
	@Test
	void contextLoad() {
		System.out.println(applicationContext);
	}
	
	@Test
	void testCreate() throws Exception {
		User user = new User("test88","test88","테스트","test@test.com");
		assertEquals(userDao.create(user), 1);
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
		User user = userDao.findUser("test88");
		assertNotNull(user);
		assertNotNull(user.getUserId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		System.out.println(user);
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
