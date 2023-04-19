package com.itwill.ilhajob.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.ilhajob.common.dto.BlogCommentDto;
import com.itwill.ilhajob.common.dto.BlogDto;
import com.itwill.ilhajob.common.entity.Blog;
import com.itwill.ilhajob.common.service.BlogCommentService;
import com.itwill.ilhajob.common.service.BlogService;
import com.itwill.ilhajob.user.controller.LoginCheck;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.service.UserService;


@Controller
public class BlogController {

	public BlogController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private BlogCommentService blogCommentService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/blog-list")
	public String blog_list(@PageableDefault(page=0, size=9, sort="id", direction=Sort.Direction.DESC) Pageable pageable, Model model) {
	    Page<BlogDto> blogList = blogService.findAll(pageable);
	    int nowPage = blogList.getPageable().getPageNumber();
	  
	    model.addAttribute("blogList", blogList);
	    model.addAttribute("nowPage",nowPage);
        model.addAttribute("totalPage", blogList.getTotalPages());
        model.addAttribute("prePage", blogList.previousOrFirstPageable().getPageNumber());
        model.addAttribute("nextPage", blogList.nextOrLastPageable().getPageNumber());

	    return "blog-list";
	}
	
	/*블로그 전체 리스트
	
	@RequestMapping("/blog-list")
	public String blog_list(Model model) throws Exception{
		String forwardPath = "";
		List<BlogDto> blogList = blogService.selectAll();
		model.addAttribute("blogList", blogList);
		forwardPath="blog-list";
		
		return forwardPath;
	}
	*/
	
	/*새 블로그 작성*/  
	@LoginCheck
	@RequestMapping("/blog-write-form")
	public String blog_write_form(HttpServletRequest request) throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		UserDto loginUser = userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		return "blog-write-form";
	}

	
	@PostMapping("/blog_write_action")
	public String blog_write_action(@ModelAttribute BlogDto blog,HttpServletRequest request,
									RedirectAttributes redirectAttributes)throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		UserDto loginUser = userService.findUser(sUserId);
		blog.setUser(loginUser);
		blogService.insertBlog(blog);
		//redirectAttributes.addAttribute("id",blog); 작성글로 가야됨...
		return "redirect:blog-single";
		}
	
	
	/*블로그 상세*/
	//블로그 Seq가 없을 때
	@RequestMapping(value = "/blog-single",params = "!id")
	public String blog_view() {
		return "redirect:blog-list";	
	}
	//블로그 Seq가 있을때
	@RequestMapping(value = "/blog-single", params = "id")
	public String blog_view(@RequestParam("id") Long blogId , Model model, @ModelAttribute BlogCommentDto blogCommentDto) throws Exception{
		//블로그 상세내용 불러오기
		BlogDto blogDto = blogService.findBlog(blogId);
		model.addAttribute("blog", blogDto);
		
		//블로그 조회수 업데이트
		model.addAttribute("blogReadCount", blogService.updateViews(blogId));
		
    
		//댓글리스트 불러오기
		List<BlogCommentDto> blogCommentList = blogCommentService.findByBlogComment(blogId);
		model.addAttribute("blogCommentList", blogCommentList);
		return "blog-single";
	}
	


	/*
	 * 블로그 댓글 작성
	 */

	@LoginCheck
	@PostMapping("/blogcomment_write_action")
	public String blogcomment_write_action(@ModelAttribute BlogCommentDto blogCommentDto, HttpServletRequest request,
									RedirectAttributes redirectAttributes)throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		UserDto loginUser = userService.findUser(sUserId);
		blogCommentDto.setUser(loginUser);
		blogCommentService.insertBlogComment(blogCommentDto);
		return "redirect:blog-single";
	
	}

}