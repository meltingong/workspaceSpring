package com.itwill.ilhajob.recruit;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.corp.CorpService;

@Controller
public class RecruitController {
	@Autowired
	private CorpService corpService;
	@Autowired
	private RecruitService recruitService;
	
	//@RequestMapping(value = {"/","/index"})
	public String main(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAllWithCorp();
		model.addAttribute("recruitList", recruitList);
		System.out.println(recruitList);
		String forward_path = "index";
		return forward_path;
	}
	
	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception{
		List<Recruit> recruitList = recruitService.findRecruitListAllWithCorp();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "recruit-list";
		return forward_path;
	}
	
	@RequestMapping(value = "/recruit-detail",params = "!rcSeq")
	public String recruit_detail() {
		return "redirect:index";	
	}
	@RequestMapping(value = "/recruit-detail",params = "rcSeq")
	public String recruit_detail(@RequestParam int rcSeq, Model model) throws Exception{
		Recruit recruit = recruitService.findRecruit(rcSeq);
		model.addAttribute("recruit", recruit);
		System.out.println(recruit);
		String forward_path = "recruit-detail";
		return forward_path;
	}
	
	   @RequestMapping("/dashboard-post-job")
	   public String dashboard_post_job_form(HttpServletRequest request,Model model) throws Exception {
		  Corp loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
	      model.addAttribute("corp",loginCorp);
	      String forward_path = "dashboard-post-job";
	      return forward_path;
	   }
	   @PostMapping("/dashboard-post-job-action")
	   public String dashboard_post_job_action(@ModelAttribute Recruit recruit,HttpServletRequest request,Model model) throws Exception {
		   Corp loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
		  recruit.setRcDeadline(new Date());
		  recruit.setCorp(loginCorp);
		  recruitService.saveRecruit(recruit);
	      model.addAttribute("rcSeq",recruit.getRcSeq());
	      String forward_path = "recruit-detail";
	      return forward_path;
	   }
	   
	   /* 수정 전 껍데기
	   //delete
	   @PostMapping(value="/recruit_remove_action")
	   public String recruit_remove_action(@RequestParam("rcSeq")int rcSeq)throws Exception{
		   return "";
	   }
	   //modify_form
	   @PostMapping(value="/recruit_modify_form")
	   public String recruit_modify_form()throws Exception{
		   return "";
	   }
	   //modify_action
	   @PostMapping(value="/recruit_modify_action")
	   public String recruit_remove_action()throws Exception{
		   return "";
	   }
	   */
	   
}
