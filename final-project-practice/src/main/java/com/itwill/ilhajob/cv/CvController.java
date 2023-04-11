package com.itwill.ilhajob.cv;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.app.AppService;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.awards.AwardsService;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.edu.EduService;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.exp.ExpService;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.user.User;
import com.itwill.ilhajob.user.controller.LoginCheck;

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
	
	/************************* cv list *******************************/
//	@LoginCheck
	@RequestMapping(value = "/cv-list")
	public String cv_list(HttpServletRequest request, Model model) {
		String forwardpath = "";
//		if(request.getSession().getAttribute("userSeq") != null) {
//			int userSeq = (int)request.getSession().getAttribute("userSeq");
		
		/* 테스트용 userSeq 세팅, 조건문 */
		request.getSession().setAttribute("userSeq", 3);
		if(request.getSession() != null) {
		/* 테스트용 userSeq 세팅, 조건문 */
			int userSeq = (int)request.getSession().getAttribute("userSeq");
			List<Cv> cvList = cvService.findCvListByUserSeq(userSeq);
			model.addAttribute("cvList", cvList);
			forwardpath = "candidate-dashboard-cv-manager";
		} 
		else {
			List<Cv> cvList = cvService.selectAll();
			model.addAttribute("cvList", cvList);
			forwardpath = "redirect:cv-write-form";
		}
		return forwardpath;
	}
	
	/************************* cv form *******************************/
	/** cv write form */
//	@LoginCheck
	@RequestMapping(value = "/cv-write-form")
	public String cv_wirte_from(HttpServletRequest request, Model model) {
//	public String cv_wirte_from(@ModelAttribute User user, Model model) {
//		int userSeq = Integer.parseInt(request.getParameter("userSeq"));
		
		/* 테스트용 userSeq 세팅 */
		request.getSession().setAttribute("userSeq", 3);
		int userSeq = (int)request.getSession().getAttribute("userSeq");
		
		/* userSeq */
//		int userSeq = user.getUserSeq();
		model.addAttribute("userSeq", userSeq);
		
		/* eduList */
//		List<Edu> eduList = user.getEduList();
		List<Edu> eduList = eduService.selectEduByUserSeq(userSeq);
		model.addAttribute("eduList", eduList);
		
		/* expList */
//		List<Exp> expList = user.getExpList();
		List<Exp> expList = expService.selectByUserSeq(userSeq);
		model.addAttribute("expList", expList);
		
		/* awardsList */
//		List<Awards> awardsList = user.getAwardsList();
		List<Awards> awardsList = awardsService.findAwardsOfUser(userSeq);
		model.addAttribute("awardsList", awardsList);
		
		String forwardpath = "candidate-dashboard-resume-write";
		return forwardpath;
	}

	/** cv detail param(cvSeq) 없을 때 */
//	@LoginCheck
	@RequestMapping(value = "/cv-detail", params = "!cvSeq")
//	public String cv_detail(int userSeq, Model model) {							// test
	public String cv_detail(@ModelAttribute User user, Model model) {
		String forwardpath = "";
		/* user cv list 가져오기 */
		List<Cv> cvList = cvService.findCvListByUserSeq(user.getUserSeq());
//		List<Cv> cvList = cvService.findCvListByUserSeq(userSeq); 				// test
		System.out.println(cvList);
		if (cvList.size() == 0) {
			forwardpath = "redirect:cv-write-form";
		} else {
			model.addAttribute("cvList", cvList);
			/* 가장 최근 작성한 cv의 detail */
			Cv cvDetail = cvService.detailCv(cvList.get(cvList.size()-1).getCvSeq());
			model.addAttribute("cvDetail", cvDetail);
			forwardpath = "candidate-dashboard-resume";
		}
		return forwardpath;
	}
	
	/** cv detail param(cvSeq) 있을 때 */
//	@LoginCheck
	@RequestMapping(value = "/cv-detail")
//	public String cv_detail(@ModelAttribute User user, @RequestParam int cvSeq, Model model) {
		public String cv_detail(HttpServletRequest request, @ModelAttribute User user, @RequestParam int cvSeq, Model model) {
		String forwardpath = "";
		
		/* 테스트용 userSeq 세팅 */
		request.getSession().setAttribute("userSeq", 3);
		int userSeq = (int)request.getSession().getAttribute("userSeq");
		model.addAttribute("userSeq", userSeq);
		System.out.println(userSeq);
		/* user cv list */
//		List<Cv> cvList = cvService.findCvListByUserSeq(user.getUserSeq());
		List<Cv> cvList = cvService.findCvListByUserSeq(userSeq); // test
		System.out.println(cvList);
		model.addAttribute("cvList", cvList);
		
		/* 특정 cv detail */
		Cv cvDetail = cvService.detailCv(cvSeq);
		model.addAttribute("cvDetail", cvDetail);
		
		/* eduList */
		List<Edu> eduList = cvDetail.getEduList();
		model.addAttribute("eduList", eduList);
		request.getSession().setAttribute("eduList", eduList);
		
		/* expList */
		List<Exp> expList = cvDetail.getExpList();
		model.addAttribute("expList", expList);
		
		/* awardsList */
		List<Awards> awardsList = cvDetail.getAwardsList();
		model.addAttribute("awardsList", awardsList);
		
		if(cvDetail != null) {
			// 어디로 보낼지 더 생각하기
			forwardpath = "redirect:cv-list";
		}
		
		forwardpath = "candidate-dashboard-resume";
		return forwardpath;
	}
	
	/************************* cv action *******************************/
	/** write_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-write-action")
	@RequestMapping(value = "/cv-write-action")
//	public String cv_write_action(@ModelAttribute Cv cv, @ModelAttribute List<Edu> eduList, RedirectAttributes redirectAttributes) {
		public String cv_write_action(@ModelAttribute Cv cv, RedirectAttributes redirectAttributes) {
		try {
			cvService.createCv(cv);
			int cvSeq = cv.getCvSeq();
			redirectAttributes.addAttribute("cvSeq", cvSeq);
//			for (Edu edu : eduList) {
//				eduService.updateEdu(edu);
//			}
//			System.out.println(eduList);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		새로 작성한 이력서 디테일로 가는데, 작성한 다른 이력서 리스트도 추가해줘야하나?(셀렉트옵션)
		return "redirect:cv-detail";
	}
	
	/** update_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@RequestMapping(value = "/cv-update-action", produces = "application/json;charset=UTF-8")
//	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, @ModelAttribute List<Awards> awardsList, @ModelAttribute Edu edu, @ModelAttribute Exp exp, Model model) {
	public String cv_update_action(HttpServletRequest request, @ModelAttribute Cv cv, @ModelAttribute Edu edu, Model model, RedirectAttributes redirectAttributes) {

		int cvSeq = cv.getCvSeq();
		cvService.updateCv(cv);
//		List<Edu> eduList = (List<Edu>)request.getSession().getAttribute("eduList");
//		for (int i = 0; i < eduList.size(); i++) {
//			date 문제 해결 필요
//			eduService.updateEdu(edu);
//		}
//		model.addAttribute("eduList", eduList);
		redirectAttributes.addAttribute("cvSeq", cvSeq);
		
		return "redirect:cv-detail";
	}

	/** delete_action */
//	@LoginCheck
//	@PostMapping(value = "/cv-delete-action")
	@RequestMapping(value = "/cv-delete-action")
	public String cv_delete_action(HttpServletRequest request, @RequestParam int cvSeq) throws Exception{
		cvService.remove(cvSeq);
		return "redirect:cv-list";
	}
	
	/*********************** cv apply action *************************/
//	@LoginCheck
//	@PostMapping("cv-apply-action")
	@RequestMapping("cv-apply-action")
	public String cv_apply_action(Model model, @ModelAttribute Cv cv, @ModelAttribute Recruit rc) {
		System.out.println(rc);
		Recruit recruit = (Recruit)model.getAttribute("recruit");
		System.out.println("model.getAttribute('recruit')" + recruit);
		App app = new App(0, 'T', recruit, cv, cv.getUserSeq(), recruit.getCorp().getCorpId(), recruit.getRcSeq());
		System.out.println("##### before insert" + app);
		appService.insertApp(app);
		System.out.println("#### after insert" + app);
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
//	@LoginCheck
//	@PostMapping(value = "/cv-update-action")
	@RequestMapping(value = "/ajax-send", produces = "application/json;charset=UTF-8")
	public Map<String, Object> cv_update_action(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		return map;
	}
	
	/** 일단 동기방식으로 테스트 */
	@RequestMapping(value = "/edu-delete-action")
	public String cv_info_delete_action(HttpServletRequest request, @ModelAttribute Edu edu, @RequestParam("eduSeq") String eduSeq, Model model, RedirectAttributes redirectAttributes) {
		System.out.println("======== eduSeq : " + eduSeq);
		System.out.println(eduSeq.replace(',', ' ').trim());
//		System.out.println(edu.getEduSeq());
		eduService.deleteEduByEduSeq(Integer.parseInt(eduSeq.replace(',', ' ').trim()));
		
		int userSeq = (int)request.getSession().getAttribute("userSeq");
		int cvSeq = cvService.findCvListByUserSeq(userSeq).get(2).getCvSeq();
		
		redirectAttributes.addAttribute("cvSeq", cvSeq);
		
		return "redirect:cv-detail";
	}
	
	@RequestMapping(value = "/exp-delete-action")
	public String cv_exp_delete_action(HttpServletRequest request, @RequestParam int expSeq) {
		System.out.println("############### expSeq : " + expSeq);
		expService.deleteExp(expSeq);
		return "redirect:cv-detail";
	}
	
}
