package com.itwill.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.jpa.entity.User;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	UserRepository userRepository;
	@Test
	void users_crud() {
		/******insert******/
		User user1 = new User("김경호1","guard1@gmail.com",new Date(),LocalDateTime.now());
		User user2 = new User("김경호2","guard2@gmail.com",new Date(),LocalDateTime.now());
		User user3 = new User("김경호3","guard3@gmail.com",new Date(),LocalDateTime.now());
		User saveUser1 = userRepository.save(user1);
		User saveUser2 = userRepository.save(user2);
		User saveUser3 = userRepository.save(user3);
		System.out.println(">>>>>saveUser1"+saveUser1);
		System.out.println(">>>>>saveUser2"+saveUser2);
		
		Optional<User> optionalUser1 = userRepository.findById(1L);
		if(optionalUser1.isPresent()) {
			User findUser1 = optionalUser1.get();
			System.out.println(">>>findUser1"+findUser1);
		}
		/*******selectAll********/
		
		List<User> userList = userRepository.findAll();
		System.out.println(">>>userList:"+userList);
		/******update********/
		Optional<User> optionalUser2 = userRepository.findById(3L);	
		if(optionalUser2.isPresent()) {
			User findUser2 = optionalUser2.get();
			findUser2.setName("깅경홍3");
			findUser2.setEmail("ganghong3@gmail.com");
			findUser2.setUpdatedAt(LocalDateTime.now().plusDays(1L));
			User updatedUser2 = userRepository.save(findUser2);
			System.out.println(">>>>>updatedUser2"+updatedUser2);
		}
		/********delete*********/
		userRepository.deleteById(3L);
		userRepository.delete(saveUser1);
		
	}
	@Test
	void select() {
		User user1 = new User("김경호1","guard1@gmail.com",new Date(),LocalDateTime.now());
		User user2 = new User("김경호2","guard2@gmail.com",new Date(),LocalDateTime.now());
		User user3 = new User("김경호3","guard3@gmail.com",new Date(),LocalDateTime.now());
		System.out.println(">>>>findByName"+userRepository.findByName("김경호1"));
		System.out.println(">>>>findByEmail"+userRepository.findByEmail("guard2@gmail.com"));
	}
	
	
	
	
	
	
}
