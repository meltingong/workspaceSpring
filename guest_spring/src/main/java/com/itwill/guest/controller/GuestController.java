package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import oracle.jdbc.proxy.annotation.Post;
@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		System.out.println(">>>GuestController");
		
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "guest_main";

		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(Model model) throws Exception {
		List<Guest> guestList = guestService.selectAll();
		model.addAttribute("guestList", guestList);
		String forwardPath = "guest_list";

		return forwardPath;
	}
	/*
	 * parameter에 guest_no가 존재하지 않을 때
	 */
	@RequestMapping(value = "/guest_view", params="!guest_no")
	public String guest_view() {
		return "redirect:guest_main";
	}
	/*
	 * parameter에 guest_no가 존재하면
	 */
	@RequestMapping(value = "/guest_view" , params ="guest_no")
	public String guest_view(@RequestParam int guest_no,Model model) throws Exception {
		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute("guest",guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}
	
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "guest_error";

		return forwardPath;
	}

	@PostMapping("/guest_modify_form")
	public String guest_modify_form(Model model,@RequestParam int guest_no) throws Exception {
		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		String forwardPath = "guest_modify_form";
		return forwardPath;
	}
	
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest) throws Exception {
		guestService.updateGuest(guest);
		String forwardPath = "redirect:guest_view?guest_no="+guest.getGuest_no();

		return forwardPath;
	}


	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam int guest_no) throws Exception {
		guestService.deleteGuest(guest_no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}

	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest) throws Exception {
		guestService.insertGuest(guest);
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
	
	@ExceptionHandler(Exception.class)
	public String guest_exception_handler(Exception e) {
		return "guest_error";
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
