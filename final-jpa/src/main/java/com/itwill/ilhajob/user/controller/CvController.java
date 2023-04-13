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
		System.out.println("userId : " + userId);
		List<CvDto> cvList = cvService.findCvByUserId(userId);
		System.out.println("$$$$ cvLIst + " + cvList);
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
	public String cv_wirte_from(HttpServletRequest request, Model model) throws Exception {
//	public String cv_wirte_from(@ModelAttribute User user, Model model) {
//		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		
		Long userId = (Long)request.getSession().getAttribute("id");

//		/* eduList */
////		List<Edu> eduList = user.getEduList();
//		List<EduDto> eduList = eduService.selectEduByUserSeq(userId);
//		model.addAttribute("eduList", eduList);
//		
//		/* expList */
////		List<Exp> expList = user.getExpList();
//		List<ExpDto> expList = expService.selectByUserSeq(userId);
//		model.addAttribute("expList", expList);
//		
		/* awardsList */
//		List<Awards> awardsList = user.getAwardsList();
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
		List<CvDto> cvList = cvService.findCvByUserId(userId);
		System.out.println(cvList);
		if (cvList.size() == 0 || cvList == null) {
			forwardpath = "redirect:cv-write-form";
		} else {
			model.addAttribute("cvList", cvList);
			/* 가장 최근 작성한 cv의 detail */
			CvDto cvDetail = cvList.get(cvList.size()-1);
			model.addAttribute("cvDetail", cvDetail);
			forwardpath = "candidate-dashboard-resume";
		}
		return forwardpath;
	}
	
	/** cv detail param(cvId) 있을 때 
	 * @throws Exception */
	@LoginCheck
	@RequestMapping(value = "/cv-detail")
		public String cv_detail(HttpServletRequest request, @RequestParam Long cvId, Model model) throws Exception {
		String forwardpath = "";
		
//		UserDto user = userService.findUser((String)request.getSession().getAttribute("sUserId"));
//		System.out.println("AwardsList" + user.getAwardsList());
//		System.out.println("EduList" + user.getEduList());
//		System.out.println("ExpList" + user.getExpList());
		
		Long userId = (Long)request.getSession().getAttribute("id");
		System.out.println("uuuuuuser id by session : " + userId);
		model.addAttribute("userId", userId);
		
		/* user cv list */
		List<CvDto> cvList = cvService.findCvByUserId((Long)request.getSession().getAttribute("id")); // test
		System.out.println("########### cvList : " + cvList);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		CvDto cvDetail = cvService.findCvById(userId);
		System.out.println("########### cvDetail : " + cvDetail);
		model.addAttribute("cvDetail", cvDetail);
		
		/* eduList */
		List<EduDto> eduList = cvDetail.getEduList();
		model.addAttribute("eduList", eduList);
		request.getSession().setAttribute("eduList", eduList);
		
		/* expList */
		List<ExpDto> expList = cvDetail.getExpList();
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
//	public String cv_write_action(@ModelAttribute Cv cv, @ModelAttribute List<Edu> eduList, RedirectAttributes redirectAttributes) {
		public String cv_write_action(@ModelAttribute CvDto cv, RedirectAttributes redirectAttributes) {
		try {
			System.out.println("@@@@@@@@cv : " + cv);
			cvService.saveCv(cv);
			System.out.println("@@@@@@@@@@ after save cv : " + cv);
			Long cvId = cv.getId();
			redirectAttributes.addAttribute("cvId", cvId);
//			for (Edu edu : eduList) {
//				eduService.updateEdu(edu);
//			}
//			System.out.println(eduList);
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
//	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, @ModelAttribute List<Awards> awardsList, @ModelAttribute Edu edu, @ModelAttribute Exp exp, Model model) {
	public String cv_update_action(HttpServletRequest request, @RequestParam Long cvId, @ModelAttribute CvDto cv, @ModelAttribute EduDto edu, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("cccccccccccc cv : " + cv);
		System.out.println("ccccccccccc cvId " + cvId);
		
//		Long cvId = cv.getId();
		cvService.updateCv(cvId, cv);
		System.out.println("@@@@@@@@@@@@@@@@@ after update : ");
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
	public String cv_delete_action(HttpServletRequest request, @RequestParam Long cvId) throws Exception{
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
	public String cv_info_delete_action(HttpServletRequest request, @ModelAttribute EduDto eduDto, @RequestParam("eduSeq") Long eduid, Model model, RedirectAttributes redirectAttributes) {
//		System.out.println("======== eduSeq : " + eduSeq);
//		System.out.println(eduSeq.replace(',', ' ').trim());
////		System.out.println(edu.getEduSeq());
//		eduService.deleteEduByEduSeq(Integer.parseInt(eduSeq.replace(',', ' ').trim()));
//		
//		int userSeq = (int)request.getSession().getAttribute("userSeq");
//		int cvSeq = cvService.findCvListByUserSeq(userSeq).get(2).getCvSeq();
//		
//		redirectAttributes.addAttribute("cvSeq", cvSeq);
		
		return "redirect:cv-detail";
	}
	
	@RequestMapping(value = "/exp-delete-action")
	public String cv_exp_delete_action(HttpServletRequest request, @RequestParam int expSeq) {
//		System.out.println("############### expSeq : " + expSeq);
//		expService.deleteExp(expSeq);
		return "redirect:cv-detail";
	}
	
}
