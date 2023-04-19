package com.itwill.ilhajob.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.LoginRequestDto;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;
import com.itwill.ilhajob.user.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class AuthController {
	
	private final UserService userService;
	private final CorpService corpService;
	
	@Autowired
	public AuthController(UserService userService, CorpService corpService) {
		this.userService = userService;
		this.corpService = corpService;
	}
	
	@PostMapping("ajaxLogin")
	public ResponseEntity<Object> ajaxLogin(@RequestBody LoginRequestDto loginRequest, @ApiIgnore HttpSession session) throws Exception {
	    if(loginRequest.getSeparate().equals("user")) {
	    	String id = loginRequest.getEmail();
	    	String password = loginRequest.getPassword();
	    	try {
				UserDto loginUser = userService.login(id,password);
				session.setAttribute("id", loginUser.getId());
				session.setAttribute("role", "user");
				session.setAttribute("sUserId", loginRequest.getEmail());
				return ResponseEntity.ok().body("{\"success\": true, \"message\": \"로그인 성공\"}");
			}catch (UserNotFoundException e) {
				return ResponseEntity.status(ResponseStatusCode.NOT_FOUND_USER).body(e.getMessage());
			}catch (PasswordMismatchException e) {
				return ResponseEntity.status(ResponseStatusCode.PASSWORD_MISMATCH_USER).body(e.getMessage());
			}
	    }else if(loginRequest.getSeparate().equals("corp")) {
	    	String id = loginRequest.getId();
	    	String password = loginRequest.getPassword();
	    	try {
				CorpDto loginCorp =  corpService.login(id, password);
				session.setAttribute("id", loginCorp.getId());
				session.setAttribute("role", "corp");
				session.setAttribute("sCorpId", id);
				return ResponseEntity.ok().body("{\"success\": true, \"message\": \"로그인 성공\"}");
			} catch (CorpNotFoundException e) {
				return ResponseEntity.status(ResponseStatusCode.NOT_FOUND_CORP).body(e.getMessage());
			} catch (PasswordMismatchException e) {
				return ResponseEntity.status(ResponseStatusCode.PASSWORD_MISMATCH_CORP).body(e.getMessage());
			}
	    }
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"success\": false, \"message\": \"잘못된 형식입니다.\", \"location\": \"/final-project-team1-ilhajob\"}");
	}

}
