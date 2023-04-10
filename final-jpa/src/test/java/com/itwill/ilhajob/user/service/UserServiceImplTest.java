package com.itwill.ilhajob.user.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.itwill.ilhajob.user.dto.UserDto;


class UserServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	UserService userService;
	
	@Disabled
	@Test
	void test() throws Exception {
		UserDto saveUser = new UserDto();
		saveUser.setUserEmail("serviceTest@test.com");
		saveUser.setUserPassword("1234");
		System.out.println(saveUser);
		userService.create(saveUser);
	}
	
	@Disabled
	@Test
	void remove() throws Exception {
		userService.remove(1L);
	}
	
	@Test
	@Transactional
	void select() throws Exception {
		//System.out.println(userService.findUser(3L));
		UserDto user = UserDto.builder()
							  .userAddress("서울시 강남구")
							  .build();
		userService.update(1L, user);
	}
}
