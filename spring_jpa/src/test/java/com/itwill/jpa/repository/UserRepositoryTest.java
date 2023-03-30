package com.itwill.jpa.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.SpringJpaApplicationTests;
import com.itwill.jpa.entity.User;

class UserRepositoryTest extends SpringJpaApplicationTests{
	@Autowired
	UserRepository userRepository;
	@Test
	void users_crud() {
		/*******insert*******/
		User user1=new User("김경호1", "guard1@gmail.com",LocalDateTime.now(),LocalDateTime.now());
		User user2=new User("김경호2", "guard2@gmail.com",LocalDateTime.now(),LocalDateTime.now());
		User user3=new User("김경호3", "guard3@gmail.com",LocalDateTime.now(),LocalDateTime.now());
		User saveUser1=userRepository.save(user1);
		User saveUser2=userRepository.save(user2);
		User saveUser3=userRepository.save(user3);
		System.out.println(">>> saveUser1:"+saveUser1);
		System.out.println(">>> saveUser2:"+saveUser2);
		System.out.println(">>> saveUser3:"+saveUser3);
		/*******find********/
	 	Optional<User> optionalUser1= userRepository.findById(1L);
	 	if(optionalUser1.isPresent()) {
	 		User findUser1 = optionalUser1.get();
	 		System.out.println(">>> findUser1:"+findUser1);
	 	}
	 	/*****findAll*****/
	 	List<User> userList = userRepository.findAll();
	 	System.out.println(">>> userList:"+userList);
	 	/*****update*****/
	 	Optional<User> optionalUser2= userRepository.findById(3L);
	 	if(optionalUser2.isPresent()) {
	 		User findUser2=optionalUser2.get();
	 		findUser2.setName("김경호삼");
	 		findUser2.setEmail("three@gmail.com");
	 		findUser2.setUpdatedAt(LocalDateTime.now().plusDays(1L));
	 		User updatedUser2= userRepository.save(findUser2);
	 		System.out.println(">>>updatedUser2:"+updatedUser2);
	 	}
	 	/*****delete*****/
	 	userRepository.deleteById(3L);
	 	userRepository.delete(saveUser1);
	 	
	 	userList = userRepository.findAll();
	 	System.out.println(">>> userList:"+userList);
	}
	@Test
	void select() {
		//System.out.println(">>> findByName:"+userRepository.findByName("김경호1"));
		//System.out.println(">>> findByEmail:"+userRepository.findByEmail("guard2@gmail.com"));
		//System.out.println(">>> findByNameAndEmail:"
		//		+userRepository.findByNameAndEmail("김경호3","guard3@gmail.com"));
		//System.out.println(">>> findByNameOrEmail:"
		//		+userRepository.findByNameOrEmail("김경호3","guard2@gmail.com"));
		
//		System.out.println(">>> findFirst2ByName:"
//				+userRepository.findFirst2ByName("김경호11"));
//		
//		System.out.println(">>> findTop2ByName:"
//				+userRepository.findTop2ByName("김경호11"));

//		System.out.println(">>> findByIdAfter:"
//				+userRepository.findByIdAfter(7L));
//		System.out.println(">>> findByIdBetween:"
//				+userRepository.findByIdBetween(7L,12L));
//		System.out.println(">>> findByCreatedAtGreaterThan:"
//				+
//				userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)).size());
//		System.out.println(">>> findByCreatedAtGreaterThanEqual:"
//				+userRepository.findByCreatedAtGreaterThanEqual(
//						LocalDateTime.now().minusDays(1L)).size());
//		System.out.println(userRepository.findByNameSQL("김경호11"));
		System.out.println(">>> findByNameContains:"+userRepository.findByNameContains("경호").size());
		System.out.println(">>> findByNameStartingWith:"+userRepository.findByNameStartingWith("김경호11").size());
		System.out.println(">>> findByNameEndingWith:"+userRepository.findByNameEndingWith("11").size());
		System.out.println(">>> findByNameLike:"+userRepository.findByNameLike("%"+"경호"+"%").size());
		
		
		
	}
	
}










