package com.itwill.ilhajob.user.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.user.dto.AwardsDto;
import com.itwill.ilhajob.user.dto.CvDto;
import com.itwill.ilhajob.user.dto.EduDto;
import com.itwill.ilhajob.user.dto.ExpDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.service.AwardsService;
import com.itwill.ilhajob.user.service.CvService;
import com.itwill.ilhajob.user.service.EduService;
import com.itwill.ilhajob.user.service.ExpService;
import com.itwill.ilhajob.user.service.UserService;

@Controller
public class EduController {
	
	@Autowired
	private EduService eduService;
	@Autowired
	private CvService cvService;
	@Autowired
	private UserService userService;
	@Autowired
	private AwardsService awardsService;
	@Autowired
	private ExpService expService;
	
	@RequestMapping(value = "/edu-create", method = RequestMethod.POST)
	public String createEdu(@ModelAttribute EduDto eduDto, HttpServletRequest request, Model model) {
		try {
			/*
			String startDateString = request.getParameter("startDate");
			String endDateString = request.getParameter("endDate");

			LocalDateTime eduStartDate = LocalDateTime.parse(startDateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			LocalDateTime eduEndDate = LocalDateTime.parse(endDateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			*/
			String userEmail = (String)request.getSession().getAttribute("sUserId");
			UserDto user = userService.findUser(userEmail);
			eduDto.setEduStartDate(LocalDateTime.now());
			eduDto.setEduEndDate(LocalDateTime.now());
			eduDto.setUser(user);
			
			eduService.createEdu(eduDto);
			System.out.println(">>>>>>>>> edu : " + eduDto);
			
			Long userId = (Long)request.getSession().getAttribute("id");
			List<CvDto> cvList = cvService.findByUserId(userId);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cv-detail";
	}
	
	@RequestMapping(value = "/edu", produces = "application/json;charset=UTF-8")
	public Map<String, Object> addEdu(@RequestBody EduDto eduDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		EduDto data = eduService.createEdu(eduDto);
		resultMap.put("data", data);
		return resultMap;
	}
	
	@RequestMapping(value="/edu/delete/{eduId}", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Map<String, Object> deleteEdu(@PathVariable("eduId") Long eduId, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(">>>>>>>>>> eduId : " + eduId);
//		System.out.println(eduid.replace(',', ' ').trim());
//		eduService.deleteEduByEduSeq(Integer.parseInt(eduid.replace(',', ' ').trim()));
		int code = 1;
		String msg = "success";
		List<EduDto> eduData = new ArrayList<EduDto>();
		try {
			eduService.deleteEdu(eduId);
			Long userId = (Long)request.getSession().getAttribute("id");
			eduData = eduService.findEduListByUserId(userId);
			
			// RedirectAttributes
			Long cvId = cvService.findByUserId(userId).get(0).getId();
			redirectAttributes.addAttribute("cvId", cvId);
			//return new ResponseEntity<>(eduList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			//return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			code = 2;
			msg = "fail";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("eduData", eduData);
		
		return resultMap;
	}
}
