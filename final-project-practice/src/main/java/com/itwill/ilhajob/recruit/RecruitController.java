package com.itwill.ilhajob.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping("/index")
	public String main(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAll();
		model.addAttribute("recruitList", recruitList);
		System.out.println(recruitList);
		String forward_path = "index";
		return forward_path;
	}
	
	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAll();
		model.addAttribute("recruitList", recruitList);
		System.out.println(recruitList);
		String forward_path = "recruit-list";
		return forward_path;
	}
	
}
