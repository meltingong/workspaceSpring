package com.itwill.ilhajob.blogComment;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.ilhajob.blog.Blog;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.blogComment.mapper")
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootBlogCommentDaoMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootBlogCommentDaoMain.class, args);
        //Awards tutorDao=(Awards)appicationContext.getBean(Awards.class);		
	    BlogCommentDao blogCommentDao=(BlogCommentDao)appicationContext.getBean(BlogCommentDao.class);
	    //System.out.println("--------findBlogComment--------");
	    //System.out.println(blogCommentDao.findBlogComment(6));    
		System.out.println("--------selectAll--------");
		System.out.println(blogCommentDao.selectAll());
	    //System.out.println("--------selectByBlogComment--------");
	    //System.out.println(blogCommentDao.selectByBlogComment(1));
	    //System.out.println("--------insertBlogComment test--------");
		//System.out.println(blogCommentDao.insertBlogComment(BlogComment.builder()
		//											.commentSeq(8)
		//											.commentContent("내용1")
		//											.commentDate(new Date())																	
		//											.userSeq(1)			
		//											.blogSeq(1)
		//											.build()));	    		                                                           		                                                        
	    //System.out.println("--------updateBlogComment test--------");
		//System.out.println(blogCommentDao.insertBlogComment(BlogComment.builder()
		//											.commentSeq(8)
		//											.commentContent("내용수정")
		//											.commentDate(new Date())																	
		//											.userSeq(1)			
		//											.blogSeq(2)
		//											.build()));
	    //System.out.println("--------deleteBlogComment--------");
	    //System.out.println(blogCommentDao.deleteBlogComment(95));
	
	}

}