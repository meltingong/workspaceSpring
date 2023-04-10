package com.itwill.ilhajob.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
import com.itwill.ilhajob.user.controller.LoginCheck;

@Controller
public class AppController {

//		@Autowired
//		private UserService userService;
		@Autowired
		private AppService appService;
		

}
