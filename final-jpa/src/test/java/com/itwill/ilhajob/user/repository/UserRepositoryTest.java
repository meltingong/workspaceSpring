package com.itwill.ilhajob.user.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;
import com.springboot.security.oauth.common.repository.AppRepository;
import com.springboot.security.oauth.user.entity.User;
import com.springboot.security.oauth.user.repository.AwardsRepository;
import com.springboot.security.oauth.user.repository.CvRepository;
import com.springboot.security.oauth.user.repository.EduRepository;
import com.springboot.security.oauth.user.repository.ExpRepository;
import com.springboot.security.oauth.user.repository.MessageRepository;
import com.springboot.security.oauth.user.repository.ReviewRepository;
import com.springboot.security.oauth.user.repository.UserRepository;

class UserRepositoryTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	UserRepository userRepository;
	@Autowired
	AppRepository appRepository;
	@Autowired
	AwardsRepository awardsRepository;
	@Autowired
	CvRepository cvRepository;
	@Autowired
	EduRepository eduRepository;
	@Autowired
	ExpRepository expRepository;
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	ReviewRepository reviewRepository;
	
	
	@Test
	void userSaveUpdate() {
		User user = User.builder()
					.userEmail("testtt@ttt.com")
					.userPassword("1111")
					.build();
		userRepository.save(user);
//		System.out.println(">>>>>>>>>>>>> awardsList : "+userRepository.findUserByAwardsList(1L));
		
//		findUser.getAwardsList().addAll(Lists.newArrayList(awards1,awards2,awards3));
		
		
//		findUser.getEduList().addAll(Lists.newArrayList(edu1,edu2,edu3));
//		findUser.getExpList().addAll(Lists.newArrayList(exp1,exp2));
		//System.out.println(expRepository.findAll());
				
	}
	
	

}
