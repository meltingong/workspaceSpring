package com.itwill.ilhajob.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.user.dto.AwardsDto;
import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.dto.EduDto;
import com.itwill.ilhajob.user.dto.ExpDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.Cv;
import com.itwill.ilhajob.user.service.AwardsService;
import com.itwill.ilhajob.user.service.CvService;
import com.itwill.ilhajob.user.service.EduService;
import com.itwill.ilhajob.user.service.ExpService;
import com.itwill.ilhajob.user.service.UserService;

@Controller
public class CvController {
	
	@Autowired
	private CvService cvService;
	@Autowired
	private AwardsService awardsService;
	@Autowired
	private EduService eduService;
	@Autowired
	private ExpService expService;
	@Autowired 
	private AppService appService;
	@Autowired
	private UserService userService;
	
	/************************* cv list *******************************/
	@LoginCheck
	@RequestMapping(value = "/cv-list")
	public String cv_list(HttpServletRequest request, Model model) {
		String forwardpath = "";
		Long userId = (Long)request.getSession().getAttribute("id");
		List<CvDto> cvList = cvService.findByUserId(userId);
		System.out.println("@@@####"  + cvList);
		if(cvList != null) {
			model.addAttribute("cvList", cvList);
			forwardpath = "candidate-dashboard-cv-manager";
		} else {
			forwardpath = "redirect:cv-write-form";
		}
		return forwardpath;
	}
	
	/************************* cv form *******************************/
	/** cv write form */
	@LoginCheck
	@RequestMapping(value = "/cv-write-form")
	public String cv_wirte_from(HttpServletRequest request, @ModelAttribute UserDto user, Model model) throws Exception {
		model.addAttribute("user" + user);
		Long userId = (Long)request.getSession().getAttribute("id");

		/* eduList */
		List<EduDto> eduList = eduService.findEduListByUserId(userId);
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<ExpDto> expList = expService.findExpListByUserId(userId);
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
		model.addAttribute("awardsList", awardsList);
		
		String forwardpath = "candidate-dashboard-resume-write";
		return forwardpath;
	}

	/** cv detail param(cvId) 없을 때 */
	@LoginCheck
	@RequestMapping(value = "/cv-detail", params = "!cvId")
	public String cv_detail(HttpServletRequest request, Model model) {
		String forwardpath = "";
		/* user cv list 가져오기 */
		Long userId = (Long)request.getSession().getAttribute("id");
		List<CvDto> cvList = cvService.findByUserId(userId);
		if (cvList == null || cvList.size() == 0) {
			forwardpath = "redirect:cv-write-form";
		} else {
			model.addAttribute("cvList", cvList);
			
			/* 가장 최근 작성한(cvId 기준) cv의 detail */
			CvDto cvDetail = cvList.get(cvList.size()-1);
			model.addAttribute("cvDetail", cvDetail);
			
			/* eduList */
			List<EduDto> eduList = eduService.findEduListByUserId(userId);
			model.addAttribute("eduList", eduList);
			
			/* expList */
			List<ExpDto> expList = expService.findExpListByUserId(userId);
			model.addAttribute("expList", expList);
			
			/* awardsList */
			List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
			model.addAttribute("awardsList", awardsList);
			
			forwardpath = "candidate-dashboard-resume";
		}
		return forwardpath;
	}
	
	/** cv detail param(cvId) 있을 때 */
	@LoginCheck
	@RequestMapping(value = "/cv-detail")
		public String cv_detail(HttpServletRequest request, @RequestParam Long cvId, Model model) throws Exception {
		String forwardpath = "";
		
		Long userId = (Long)request.getSession().getAttribute("id");
		model.addAttribute("userId", userId);
		
		/* user cv list */
		List<CvDto> cvList = cvService.findByUserId(userId);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		CvDto cvDetail = cvService.findCvById(cvId);
		model.addAttribute("cvDetail", cvDetail);
		
		/* eduList */
		List<EduDto> eduList = eduService.findEduListByUserId(userId);
		model.addAttribute("eduList", eduList);
		
		/* expList */
		List<ExpDto> expList = expService.findExpListByUserId(userId);
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<AwardsDto> awardsList = awardsService.findAwardsByUserId(userId);
		model.addAttribute("awardsList", awardsList);
		
		if(cvList == null || cvDetail != null) {
			forwardpath = "redirect:cv-list";
		}
		
		forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
	
	/************************* cv action *******************************/
	/** write_action */
	@LoginCheck
//	@PostMapping(value = "/cv-write-action")
	@RequestMapping(value = "/cv-write-action")
	public String cv_write_action(HttpServletRequest request, @ModelAttribute CvDto cv, RedirectAttributes redirectAttributes) {
		try {
			String userEmail = (String)request.getSession().getAttribute("sUserId");
			UserDto user = userService.findUser(userEmail);
			cv.setUser(user);
			cvService.saveCv(cv);
			
//			for (Edu edu : eduList) {
//				eduService.updateEdu(edu);
//			}
//			System.out.println(eduList);
			
			// redirectAttributes
			Long cvId = cv.getId();
			redirectAttributes.addAttribute("cvId", cvId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cv-detail";
	}
	
	/** update_action */
	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@RequestMapping(value = "/cv-update-action", produces = "application/json;charset=UTF-8")
	public String cv_update_action(HttpServletRequest request, @RequestParam Long cvId , @ModelAttribute CvDto cv, @ModelAttribute EduDto edu, Model model, RedirectAttributes redirectAttributes) throws Exception {
		String userEmail = (String)request.getSession().getAttribute("sUserId");
		UserDto user = userService.findUser(userEmail);
		cv.setUser(user);
		cvService.updateCv(cvId, cv);
		
//		List<Edu> eduList = (List<Edu>)request.getSession().getAttribute("eduList");
//		for (int i = 0; i < eduList.size(); i++) {
//			date 문제 해결 필요
//			eduService.updateEdu(edu);
//		}
//		model.addAttribute("eduList", eduList);
		
		redirectAttributes.addAttribute("cvId", cvId);
		
		return "redirect:cv-detail";
	}

	/** delete_action */
	@LoginCheck
//	@PostMapping(value = "/cv-delete-action")
	@RequestMapping(value = "/cv-delete-action")
	public String cv_delete_action(HttpServletRequest request, @RequestParam(name = "cvId") Long cvId) throws Exception {
		cvService.removeById(cvId);
		return "redirect:cv-list";
	}
	
	/*********************** cv apply action *************************/
	@LoginCheck
//	@PostMapping("cv-apply-action")
	@RequestMapping("cv-apply-action")
	public String cv_apply_action(Model model, @ModelAttribute CvDto cvDto, @ModelAttribute RecruitDto rc) {
		System.out.println(rc);
		RecruitDto recruit = (RecruitDto)model.getAttribute("recruit");
		System.out.println("model.getAttribute('recruit')" + recruit);
//		AppDto app = new AppDto(0, 'T', recruit, cvDto, cvDto.getUserSeq(), recruit.getCorp().getId(), recruit.getId());
//		System.out.println("##### before insert" + app);
//		appService.insertApp(app);
//		System.out.println("#### after insert" + app);
		return "redirect:candidate-dashboard-applied-job";
	}
	
	/************** Get 방식 요청 처리
	@GetMapping(value = {"/cv-write-action", "/cv-update-action", "/cv-delete-action"})
	public String cv_get() {
		// 메인 또는 cv-list로 이동
		return "redirect:cv-list";
	}
	 **************/
	
	

	/** << ajax >> edu_write_action */
	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@RequestMapping(value = "/ajax-send", produces = "application/json;charset=UTF-8")
	public Map<String, Object> cv_update_action(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		return map;
	}
	
	/** 일단 동기방식으로 테스트 */
	@RequestMapping(value = "/edu-delete-action")
	public String cv_info_delete_action(HttpServletRequest request, @ModelAttribute EduDto eduDto, @RequestParam("eduId") Long eduid, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("======== eduId : " + eduid);
//		System.out.println(eduid.replace(',', ' ').trim());
//		eduService.deleteEduByEduSeq(Integer.parseInt(eduid.replace(',', ' ').trim()));
		eduService.deleteEdu(eduid);
		Long userId = (Long)request.getSession().getAttribute("id");
		Long cvId = cvService.findByUserId(userId).get(0).getId();
		redirectAttributes.addAttribute("cvId", cvId);
		
		return "redirect:cv-detail";
	}
	
	@RequestMapping(value = "/exp-delete-action")
	public String cv_exp_delete_action(HttpServletRequest request, @RequestParam int expSeq) {
//		System.out.println("############### expSeq : " + expSeq);
//		expService.deleteExp(expSeq);
		return "redirect:cv-detail";
	}
	
}
