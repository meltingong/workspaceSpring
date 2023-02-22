package com.itwill2.bean.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

@SpringBootApplication
@ComponentScan({"com.itwill.guest","com.itwill.user"})
public class SpringBootBeanDependencyInjectionMain {

	public static void main(String[] args) throws Exception {
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성시작]-----------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanDependencyInjectionMain.class, args);
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성 끝]-----------");
		GuestService guestService = applicationContext.getBean(GuestService.class);
		System.out.println("-----------Constructor Injection-----------");
		guestService.selectAll();
		System.out.println("-----------Setter Injection-----------");
		UserService userService = (UserService)applicationContext.getBean(UserService.class);
		userService.create(null);
		
		
	}

}
