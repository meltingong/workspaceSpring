package com.itwill.ilhajob.corp.controller;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Recruit;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.controller.LoginCheck;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
public class RecruitController {
	@Autowired
	private CorpService corpService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private TagService tagService;
	@Autowired
	private RecruitTagService recruitTagService;
	
	@RequestMapping(value = { "/", "/index" })
	public String main(Model model) throws Exception {
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		String forward_path = "index";
		return forward_path;
	}

	@RequestMapping("/recruit-list")
	public String recruit_list(Model model) throws Exception {
		//공고리스트
		List<RecruitDto> recruitList = recruitService.findRecruitAll();
		model.addAttribute("recruitList", recruitList);
		
		//태그리스트
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
		List<TagDto> tagList = tagService.selectAll();
		model.addAttribute("recruitTagList", recruitTagList);
		model.addAttribute("tagList", tagList);
		
		String forward_path = "recruit-list";
		return forward_path;
		
		
	}

	@RequestMapping(value = "/recruit-detail", params = "!id")
	public String recruit_detail() {
		return "redirect:index";
	}

	//@LoginCheck
	@RequestMapping(value = "/recruit-detail", params = "id")
	public String recruit_detail(@RequestParam long id, Model model) throws Exception {
		RecruitDto recruit = recruitService.findRecruit(id);
		model.addAttribute("recruit", recruit);
		List<ManagerDto> managerList = managerService.findManagerByCorpID(recruit.getCorp().getId());
		model.addAttribute("managerList", managerList);
		
		
		//공고태그리스트 선별
		List<RecruitTagDto> recruitTagList = recruitTagService.selectAllByRecruitId(id);
		List<String> recruitTagNameList = new ArrayList<String>();
		for (RecruitTagDto recruitTagDto : recruitTagList) {
			TagDto tag = tagService.selectTag(recruitTagDto.getTagId());
			recruitTagNameList.add(tag.getTagName());
		}
		model.addAttribute("recruitTagNameList", recruitTagNameList);
		
		
		String forward_path = "recruit-detail";
		return forward_path;
	}

	@RequestMapping("/dashboard-post-job")
	public String dashboard_post_job_form(HttpServletRequest request, Model model) throws Exception {
		CorpDto loginCorp = corpService.findByCorpId((Long) request.getSession().getAttribute("sCorpId"));
		model.addAttribute("corp", loginCorp);
		String forward_path = "dashboard-post-job";
		return forward_path;
	}

	@PostMapping("/dashboard-post-job-action")
	public String dashboard_post_job_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request)
			throws Exception {
		CorpDto loginCorp = corpService.findByCorpId((Long) request.getSession().getAttribute("sCorpId"));
		recruitDto.setRcDate(LocalDateTime.now());
		recruitDto.setRcDeadline(LocalDateTime.now());
		recruitDto.setCorp(loginCorp);
		recruitDto = recruitService.create(recruitDto);
		String forward_path = "redirect:recruit-detail?id=" + recruitDto.getId();
		return forward_path;
	}

	// 테스트아직 안함
//	   @PostMapping("/dashboard-post-remove-action")
//	   public String dashboard_post_remove_action(@ModelAttribute RecruitDto recruitDto, HttpServletRequest request) throws Exception {
//		  CorpDto loginCorp = corpService.findCorp((String)request.getSession().getAttribute("sCorpId"));
//		  System.out.println(recruitDto);
//		  //recruitService.remove(0);
//	      String forward_path = "redirect:recruit-list";
//	      return forward_path;
//	   }

	
	@PostMapping("/recruit-delete-action")
	public String recruit_delete_action(@ModelAttribute RecruitDto recruitDto) throws Exception {
		//System.out.println("삭제 전");
		//System.out.println(">>>>>>>recruit>>>>>>>" + recruitDto);
		System.out.println(recruitDto.getId());
		recruitService.remove(recruitDto.getId());
		//System.out.println("삭제 후");
		return "redirect:dashboard-manage-job";
	}
 
	@RequestMapping("/recruit-modify-form")
	public String recruit_modify_form(HttpServletRequest request,@ModelAttribute RecruitDto recruitDto, Model model) throws Exception {
		// 일단 회사 정보가져와서 담기
		Long sCorpId =(Long)request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findByCorpId(sCorpId);
		recruitDto.setCorp(corpDto);
		
		RecruitDto setRecruit=recruitService.findRecruit(recruitDto.getId());
		System.out.println("setRecruit>>>"+setRecruit);
		model.addAttribute("recruit",setRecruit);

		return "recruit-modify-form";
	}
	
	@RequestMapping("/recruit-modify-action")
	public String recruit_modify_action(@ModelAttribute RecruitDto recruitDto,Model model,HttpServletRequest request) throws Exception {
		Long sCorpId =(Long)request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findByCorpId(sCorpId);
		recruitDto.setCorp(corpDto);
		recruitDto.setRcDate(LocalDateTime.now());
		//마감일=등록일+30일로 설정
		recruitDto.setRcDeadline(LocalDateTime.now().plusDays(30));
		//System.out.println("pre modify action >>>>"+recruitDto);
		
		RecruitDto checkRecruit = recruitService.update(recruitDto);
		//System.out.println("update check>>>>"+checkRecruit);
		model.addAttribute("id",recruitDto.getId());
		return "redirect:recruit-detail?id=" + recruitDto.getId();
		
		//RecruitDto updateRecruit= recruitService.update(recruitDto);
		//System.out.println("updateRecruit>>>"+updateRecruit);
		//model.addAttribute("updateRecruit", updateRecruit);
	}
	
	
	
}
