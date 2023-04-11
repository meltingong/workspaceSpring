package com.itwill.ilhajob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
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
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		AuthLoginAnnotationInterceptor annotationInterceptor = new AuthLoginAnnotationInterceptor();
		registry.addInterceptor(annotationInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/images/**");
		
	}
	/*********************Spring MVC 빈객체등록*********************/

}
