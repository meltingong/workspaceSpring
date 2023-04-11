package com.itwill.ilhajob.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication()
//@MapperScan(basePackages = "com.itiwll.ilhajob.Awards.mapper")
public class SpringBootLoginMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootLoginMain.class, args);

	}

}
;