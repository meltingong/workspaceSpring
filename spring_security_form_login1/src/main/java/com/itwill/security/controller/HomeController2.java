package com.itwill.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller
public class HomeController2 {
	@GetMapping("/")
	public String main() {
		return "index";
	}

}
