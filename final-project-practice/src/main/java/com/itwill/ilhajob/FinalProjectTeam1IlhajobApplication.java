package com.itwill.ilhajob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
		/*
		ApplicationContext applicationContext=SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
		EntityListenerTestService entityListenerTestService=
				(EntityListenerTestService)applicationContext.getBean(EntityListenerTestService.class);
		entityListenerTestService.createUserMessage();
		 */
	}

}
