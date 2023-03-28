package com.itwill.transaction;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.transaction.spring.Employee;
import com.itwill.transaction.spring.EmployeeService;

@SpringBootApplication
public class SpringTransactionApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringTransactionApplication.class, args);
		System.out.println("=============update전====================");
		EmployeeService service = (EmployeeService) applicationContext.getBean("empService");
		List<Employee> emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		try {

			service.increaseSalaryForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=============update후==============");

		emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}

	}

}
