package com.itwill.ilhajob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.itwill.ilhajob.user",
											"com.itwill.ilhajob.corp",
											"com.itwill.ilhajob.common",
											"com.itwill.ilhajob.config"})
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
	}

}
