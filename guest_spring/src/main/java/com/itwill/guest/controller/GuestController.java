package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
	@Autowired
	GuestService guestService;
	
	public GuestController() {
		System.out.println(">>>GuestController");
		
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "guest_main";

		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(HttpServletRequest request) throws Exception {
		List<Guest> guestList = guestService.selectAll();
		request.setAttribute("guestList", guestList);
		String forwardPath = "guest_list";

		return forwardPath;
	}
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "guest_error";

		return forwardPath;
	}

	@RequestMapping("/guest_modify_action")
	public String guest_modify_action(HttpServletRequest request) throws Exception {
		String guest_noStr = request.getParameter("guest_no");
		String guest_name = request.getParameter("guest_name");
		String guest_email = request.getParameter("guest_email");
		String guest_homepage = request.getParameter("guest_homepage");
		String guest_title = request.getParameter("guest_title");
		String guest_content = request.getParameter("guest_content");
		Guest updateGuest = new Guest(Integer.parseInt(guest_noStr),guest_name,null,guest_email,guest_homepage,guest_title,guest_content);
		guestService.updateGuest(updateGuest);
		String forwardPath = "redirect:guest_view?guest_no="+guest_noStr;

		return forwardPath;
	}

	@RequestMapping("/guest_modify_form")
	public String guest_modify_form(HttpServletRequest request) throws Exception {
		String guest_noStr = request.getParameter("guest_no");
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
		request.setAttribute("guest", guest);
		String forwardPath = "guest_modify_form";
		return forwardPath;
	}
	

	@PostMapping("/guest_remove_action")
	public String guest_remove_action(HttpServletRequest request) throws Exception {
		String guest_noStr = request.getParameter("guest_no");
		guestService.deleteGuest(Integer.parseInt(guest_noStr));
		String forwardPath = "redirect:guest_list";

		return forwardPath;
	}
	@RequestMapping("/guest_view")
	public String guest_view(HttpServletRequest request) throws Exception {
		String guest_noStr = request.getParameter("guest_no");
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
		request.setAttribute("guest",guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}

	@RequestMapping("/guest_write_action")
	public String guest_write_action(HttpServletRequest request) throws Exception {
		
		String guest_name = request.getParameter("guest_name");
		String guest_email = request.getParameter("guest_email");
		String guest_homepage = request.getParameter("guest_homepage");
		String guest_title = request.getParameter("guest_title");
		String guest_content = request.getParameter("guest_content");
		
		Guest guest = new Guest(0,guest_name,null,guest_email,guest_homepage,guest_title,guest_content);
		guestService.insertGuest(guest);
		request.setAttribute("guest", guest);
		String forwardPath = "redirect:guest_list";

		return forwardPath;
	}

	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		String forwardPath = "guest_write_form";
		return forwardPath;

	}
	@GetMapping(value={"guest_modify_form","guest_modify_action","guest_remove_action","guest_write_action"})
	public String guest_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	
	/*
	 public String guest_write_form() {
		String forwardPath = "guest_write_form";
		return forwardPath;

	}
	public String guest_write_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_remove_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	

	public String guest_modify_form_get() {
		String forwardPath = "";

		return forwardPath;
	}

	public String guest_modify_action_get() {
		String forwardPath = "";

		return forwardPath;
	}
	*/
}
