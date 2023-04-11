package com.itwill.ilhajob.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value =  "login_action")
	public String login_action() {
		
		return "";
	}
}
