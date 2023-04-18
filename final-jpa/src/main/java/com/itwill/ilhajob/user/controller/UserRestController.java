package com.itwill.ilhajob.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.controller.ResponseStatusCode;
import com.itwill.ilhajob.common.dto.LoginRequestDto;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corp.exception.ExistedCorpException;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.user.dto.ReviewDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.exception.ExistedUserException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;
import com.itwill.ilhajob.user.service.ReviewService;
import com.itwill.ilhajob.user.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class UserRestController {
	
	private final UserService userService;
	
	private final AppService appService;

	private final ReviewService reviewService;
	
	private final CorpService corpService;
	
	@Autowired
	public UserRestController(UserService userService, AppService appService, ReviewService reviewService, CorpService corpService) {
		this.userService = userService;
		this.appService = appService;
		this.reviewService = reviewService;
		this.corpService = corpService;
	}
	
	@PostMapping("ajaxRegister")
	public ResponseEntity<Object> ajaxModfiy(@RequestBody LoginRequestDto loginRequest,@ApiIgnore HttpSession session) throws Exception {
	   if(loginRequest.getSeparate().equals("user")) {
		   String id = loginRequest.getEmail();
		   String password = loginRequest.getPassword();
		   UserDto user = new UserDto(0L,id,password);
		   try {
			   userService.create(user);
			   return ResponseEntity.ok().body("{\"success\": true, \"message\": \"가입 성공\"}");
		   }catch (ExistedUserException e) {
			 return ResponseEntity.status(ResponseStatusCode.EXISTED_USER).body(e.getMessage());
		}
	   }else if(loginRequest.getSeparate().equals("corp")) {
		   String id = loginRequest.getId();
		   String password = loginRequest.getPassword();
		   CorpDto corp = new CorpDto(0L,id,password);
		 try {
			   corpService.create(corp);
			   return ResponseEntity.ok().body("{\"success\": true, \"message\": \"가입 성공\"}");
		   }catch (ExistedCorpException e) {
			   return ResponseEntity.status(ResponseStatusCode.NOT_FOUND_CORP).body(e.getMessage());
		   }
	   }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"잘못된 형식입니다.\", \"location\": \"/final-project-team1-ilhajob\"}");
	}
	

	@PostMapping("ajaxModify")
	public ResponseEntity<Object> ajaxModify(@RequestBody LoginRequestDto loginRequest,HttpSession session) throws Exception {
		
		return null;
	}
	
	/*
	 * 리뷰 작성중 ajax 방식
	 */
	
	//test x
	/*
	@PostMapping("/createReview")
	public ResponseEntity<Object> createReview(@RequestBody ReviewDto reviewDto, HttpSession session) {
	    String userEmail = (String) session.getAttribute("userEmail");
	    if(userEmail == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"로그인이 필요합니다.\", \"location\": \"/final-project-team1-ilhajob/login\"}");
	    }
	    try {
	        userService.insertReview(reviewDto);
	        return ResponseEntity.ok().body("{\"success\": true, \"message\": \"리뷰가 성공적으로 작성되었습니다.\"}");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false, \"message\": \"리뷰 작성에 실패했습니다. 잠시 후 다시 시도해주세요.\"}");
	    }
	}
	*/ //Review Ajax방식 작성중
}