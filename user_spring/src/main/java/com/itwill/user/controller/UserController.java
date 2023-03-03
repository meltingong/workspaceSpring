package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}
	@RequestMapping("/user_write_action")
	public String user_write_action_post(@ModelAttribute User user) throws Exception {
		userService.create(user);
		String forward_path = "redirect:user_login_form";
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@RequestMapping("/user_login_action")
	public String user_login_action_post(HttpServletRequest request,@ModelAttribute User user) throws Exception {
		HttpSession session = request.getSession();
		String forwardPath = "";
		User fuser= new User(user.getUserId(),user.getPassword(),"","");
		int login = userService.login(user.getUserId(), user.getPassword());
		if(login == 0) {
			String msg1 = user.getUserId()+"는 존재하지 않는 아이디 입니다.";
			request.setAttribute("msg1", msg1);
			request.setAttribute("fuser", fuser);
			forwardPath = "user_login_form";
		}else if(login ==1) {
			String msg2 = "아이디 또는 비밀번호가 일치하지 않습니다.";
			request.setAttribute("msg2", msg2);
			request.setAttribute("fuser", fuser);
			forwardPath = "user_login_form";
		}else {
			session.setAttribute("sUserId", fuser.getUserId());
			forwardPath = "redirect:user_main";
			
		}
		
		return forwardPath;
	}
	
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}else {
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath = "user_view";
		}
		return forwardPath;
	}

	@PostMapping("/user_modify_form")
	public String user_modify_form_post(HttpServletRequest request) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}else {
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath = "user_modify_form";
		}

		return forwardPath;
	}
	@PostMapping("/user_modify_action")
	public String user_modify_action_post(HttpServletRequest request,@ModelAttribute User user) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}else {
			userService.update(user);
			forwardPath = "redirect:user_view";
		}
		return forwardPath;
	}
	@PostMapping("/user_remove_action")
	public String user_remove_action_post(HttpServletRequest request) throws Exception {
		/************** login check **************/
		HttpSession session = request.getSession();
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}
		userService.remove(sUserId);
		session.invalidate();
		forwardPath = "redirect:user_main";
		
		return forwardPath;
	}
	
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		/************** login check **************/
		HttpSession session = request.getSession();
		String forwardPath = "";
		String sUserId=(String)session.getAttribute("sUserId");
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}else {
			session.invalidate();
			forwardPath = "redirect:user_main";
		}
		return forwardPath;
	}
	
	public String user_action_get() {
		String forwardPath = "";
		return forwardPath;
	}


}
