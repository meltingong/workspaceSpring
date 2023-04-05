package com.itwill.ilhajob.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.UserService;
import com.itwill.ilhajob.user.controller.LoginCheck;

@Controller
public class AppController {

		@Autowired
		private UserService userService;
		@Autowired
		private AppService appService;
		
		//회원의 my applied job보기
		@LoginCheck
		@RequestMapping("/candidate-dashboard-applied-job")
		public String user_applied_job(HttpServletRequest request, User user) throws Exception{
			String forwardPath="";
			int userSeq = user.getUserSeq();
			String sUserId = (String)request.getSession().getAttribute("sUserId");
			User loginUser = userService.findUser(sUserId);
			userService.findAppList(userSeq);
			request.setAttribute("loginUser", loginUser);
			forwardPath = "candidate-dashboard-applied-job";
			return forwardPath;
		}
}
