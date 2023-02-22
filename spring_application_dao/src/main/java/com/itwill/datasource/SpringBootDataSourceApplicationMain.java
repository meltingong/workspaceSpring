package com.itwill.datasource;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDataSourceApplicationMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootDataSourceApplicationMain.class, args);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println("1. DataSource:"+dataSource);
		System.out.println("2. Connection:"+dataSource.getConnection());
		
	}

}
