package com.itwill2.bean.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBeanDependencyInjectionMain {

	public static void main(String[] args) {
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성시작]-----------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootBeanDependencyInjectionMain.class, args);
		System.out.println("---------------Spring Container초기화 시작[ApplicationContext객체 생성 끝]-----------");

	}

}
