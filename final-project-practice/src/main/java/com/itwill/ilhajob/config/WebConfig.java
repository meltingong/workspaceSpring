package com.itwill.ilhajob.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.itwill.ilhajob.user.controller.AuthLoginAnnotationInterceptor;



@Configuration
public class WebConfig implements WebMvcConfigurer{
	/********************WebMvcConfigurer재정의*********************
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	*************************************************************/
	/*
	 * 인터셉터등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		AuthLoginInterceptor authLoginInterceptor=new AuthLoginInterceptor();
		registry.addInterceptor(authLoginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/image/**")
		.excludePathPatterns("/user_main")
		.excludePathPatterns("/user_login_form")
		.excludePathPatterns("/user_login_action")
		.excludePathPatterns("/user_write_form")
		.excludePathPatterns("/user_write_action");
		*/
		AuthLoginAnnotationInterceptor authLoginAnnotationInterceptor=
				new AuthLoginAnnotationInterceptor();
		registry.addInterceptor(authLoginAnnotationInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/image/**");
		
	}
	/*********************Spring MVC 빈객체등록*********************/

}
