package com.itwill.ilhajob.blogComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogCommentController {
	
	@Autowired
	private BlogCommentService blogCommentService;

}
