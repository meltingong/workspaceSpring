package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMissMatchException;
import com.itwill.user.exception.UserNotFoundException;
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
	public String user_write_action_post(@ModelAttribute("fuser") User user,Model model) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
		    forward_path="redirect:user_login_form";
		} catch (ExistedUserException e) {
			 model.addAttribute("msg",e.getMessage());
			 forward_path="user_write_form";
		}
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	@PostMapping("/user_login_action")
	public String user_login_action_post(@ModelAttribute("fuser") User user,Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			forwardPath = "redirect:user_main";
		}catch (UserNotFoundException e1) {
			e1.printStackTrace();
			model.addAttribute("msg1",e1.getMessage());
			forwardPath = "user_login_form";
		}catch (PasswordMissMatchException e2) {
			e2.printStackTrace();
			model.addAttribute("msg2",e2.getMessage());
			forwardPath = "user_login_form";
		}
		
		return forwardPath;
	}
	
	@RequestMapping("/user_view")
	public String user_view(HttpServletRequest request) throws Exception {
		/************** login check **************/
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			return "redirect:user_login_form";
		}else {
			User loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath = "user_view";
		}
		return forwardPath;
	}

	@PostMapping("/user_modify_form")
	public String user_modify_form_post(HttpSession session, Model model) throws Exception {
		/************** login check **************/
		String sUserId = (String)session.getAttribute("sUserId");
		String forwardPath = "";
		if(sUserId == null) {
			forwardPath = "redirect:user_login_form";
		}else {
			User loginUser = userService.findUser(sUserId);
			model.addAttribute("loginUser", loginUser);
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
		//forwardPath = "forward:user_logout_action";
		return forwardPath;
	}
	
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		/************** login check **************/
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId == null) {
			return "redirect:user_login_form";
		}
		request.getSession().invalidate(); //false일 경우 null반환
		forwardPath = "redirect:user_main";
		
		return forwardPath;
	}
	
	@GetMapping({"user_write_action","user_remove_action","user_login_action","user_modify_form"})
	public String user_action_get() {
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}

}
