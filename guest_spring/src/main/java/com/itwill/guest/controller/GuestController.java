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

	public String guest_list() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_error() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_modify_action_get() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_modify_action() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_modify_get() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_modify_form() {
		String forwardPath = "";
		return forwardPath;
	}

	public String guest_remove_action_get() {
		String forwardPath = "";
		return forwardPath;
	}

	
	public String guest_remove_action() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_view() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_write_action_get() {
		String forwardPath = "";
		return forwardPath;
	}

	public String guest_write_action() {
		String forwardPath = "";

		return forwardPath;
	}

	
	public String guest_write() {
		String forwardPath = "";
		return forwardPath;

	}

}
