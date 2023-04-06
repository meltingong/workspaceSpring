package com.itwill.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class HomeRestController1 {
	@PreAuthorize("hasAnyAuthority('ROLE_ANONYMOUS')")
	@GetMapping("/")
	public String index() {
		return "홈페이지";
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")
	@GetMapping("/user")
	public SecurityMessage1 user() {
		
		return SecurityMessage1.builder()
							  .authentication(SecurityContextHolder.getContext().getAuthentication())
							  .message("유저정보")
							  .build();
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/admin")
	public SecurityMessage1 admin() {
		
		return SecurityMessage1.builder()
				.authentication(SecurityContextHolder.getContext().getAuthentication())
				.message("관리자정보")
				.build();
	}
	
	@GetMapping("/auth")
	public Authentication authentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
}
