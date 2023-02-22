package com.itwill1.bean.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;
/*
 * @SpringBootApplication
  	- 현재 클래스가 위치하는 패키지와 하위패키지의 클래스의 @Annotation을 스캔해서 
  	  초기화(객체생성, 의존성 주입)
 */
@SpringBootApplication
/*
@ComponentScan(basePackages = {"com.itwill.guest"})
@ComponentScan(value = {"com.itwill.guest"})
*/
@ComponentScan(basePackages = {"com.itwill.guest","com.itwill.user"})
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성시작]-----------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanCreateApplicationMain.class, args);
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성 끝]-----------");
		System.out.println("-----빈의 아이디로 Container에 등록되어 있는 스프링빈 참조 얻기-----");
		UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		UserService userDService = (UserService)applicationContext.getBean("userService");
		GuestDao guestDao = (GuestDao)applicationContext.getBean("guestDao");
		GuestService guestService = (GuestService)applicationContext.getBean("guestService");
		System.out.println(userDao);
		System.out.println(userDService);
		System.out.println(guestDao);
		System.out.println(guestService);
		System.out.println("-----빈의 클래스로 Container에 등록되어 있는 스프링빈 참조 얻기-----");
		UserDao userDao2 = (UserDao)applicationContext.getBean(UserDao.class);
		UserService userDService2 = (UserService)applicationContext.getBean(UserService.class);
		GuestDao guestDao2 = (GuestDao)applicationContext.getBean(GuestDao.class);
		GuestService guestService2 = (GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(userDao2);
		System.out.println(userDService2);
		System.out.println(guestDao2);
		System.out.println(guestService2);
		System.out.println("------빈의 scope[singleton]----");
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestDao.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		System.out.println(applicationContext.getBean(GuestService.class));
		System.out.println("------빈의 scope[prototype]----");
		System.out.println(applicationContext.getBean(User.class));
		System.out.println(applicationContext.getBean(User.class));
		System.out.println(applicationContext.getBean(User.class));
		
		
		
	}

}
