package com.itwill.ilhajob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.blog.Blog;
import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.corpimage.CorpImage;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.message.Message;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.review.Review;
import com.itwill.ilhajob.user.User;

@SpringBootApplication(scanBasePackageClasses = 
	{User.class, Corp.class,CorpImage.class,
	 App.class, Recruit.class, Cv.class,
	 Edu.class, Exp.class, Awards.class,
	 Review.class, Blog.class, Message.class})
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
		System.out.println("통합테스트");
	}

}
