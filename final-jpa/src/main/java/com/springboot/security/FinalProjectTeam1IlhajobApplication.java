package com.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.itwill.ilhajob.user",
											"com.itwill.ilhajob.corp",
											"com.itwill.ilhajob.common",
											"com.itwill.ilhajob.config"})
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
}
