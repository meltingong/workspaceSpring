package com.itwill.guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class GuestController {
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";

		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list() {
		String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";

		return forwardPath;
	}
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		return forwardPath;
	}
	//@RequestMapping("/guest_modify_action_get")
	public String guest_modify_action_get() {
		String forwardPath = "";

		return forwardPath;
	}
	@RequestMapping("/guest_modify_action")
	public String guest_modify_action() {
		String forwardPath = "forward:/WEB-INF/views/guest_modify_action.jsp";

		return forwardPath;
	}
	//@RequestMapping("/guest_error")
	public String guest_modify_get() {
		String forwardPath = "";

		return forwardPath;
	}
	@RequestMapping("/guest_modify_form")
	public String guest_modify_form() {
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}
	
	public String guest_remove_action_get() {
		String forwardPath = "";
		return forwardPath;
	}

	@RequestMapping("/guest_remove_action")
	public String guest_remove_action() {
		String forwardPath = "forward:/WEB-INF/views/guest_remove_action.jsp";

		return forwardPath;
	}
	@RequestMapping("/guest_view")
	public String guest_view() {
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";

		return forwardPath;
	}
	//@RequestMapping("/")
	public String guest_write_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	@RequestMapping("/guest_write_action")
	public String guest_write_action() {
		String forwardPath = "forward:/WEB-INF/views/guest_write_action.jsp";

		return forwardPath;
	}

	@RequestMapping("/guest_write")
	public String guest_write() {
		String forwardPath = "forward:/WEB-INF/views/guest_write.jsp";
		return forwardPath;

	}

}
