package com.itwill.ilhajob.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.ilhajob.blogComment.BlogComment;
import com.itwill.ilhajob.blogComment.BlogCommentService;


@Controller
public class BlogController {

	public BlogController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private BlogCommentService blogCommentService;
	

	@RequestMapping("/blog-list-v3")
	public String blog_list(Model model) throws Exception{
		String forwardPath = "";
		List<Blog> blogList = blogService.selectAll();
		model.addAttribute("blogList", blogList);
		forwardPath="blog-list-v3";

		return forwardPath;
	}

	@RequestMapping(value = "/blog-single",params = "!blogSeq")
	public String blog_view() {
		return "redirect:index";	
	}

	@RequestMapping(value = "/blog-single",params = "blogSeq")
	public String blog_view(@RequestParam int blogSeq , Model model, @ModelAttribute BlogComment blogComment) throws Exception{
		Blog blog = blogService.findBlog(blogSeq);
		model.addAttribute("blog", blog);
		
		List<BlogComment> blogCommentList = blogCommentService.selectByBlogComment(blogSeq);
		model.addAttribute("blogCommentList", blogCommentList);
		
		return "blog-single";
	}
	

	@RequestMapping(value = "blog-single/{blogSeq}")
	public String blog_readCount(@RequestParam int blogSeq, Model model) {
		int blogReadCount = blogService.updateBlogReadCount(blogSeq);
		model.addAttribute("blogReadCount", blogReadCount);
    
    return "blog-single/{blogSeq}";
	}


}