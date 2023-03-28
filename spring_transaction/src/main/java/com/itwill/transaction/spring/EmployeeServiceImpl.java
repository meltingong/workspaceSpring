package com.itwill.transaction.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void registerEmployee(Employee person) {
		employeeDao.insert(person);
	}

	public void deleteEmployee(int idx) {
		employeeDao.delete(idx);
	}

	public void udpateEmployee(Employee emp) {
		employeeDao.update(emp);
	}

	public List<Employee> getEmps() {
		return employeeDao.list();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
	public void increaseSalaryForAll() {
		
		List<Employee> emps = getEmps();
		int random_index = (int)(Math.random()*3);
		int index = 1;
		for (Employee emp : emps) {
			employeeDao.increaseSalary(						
				emp.getId(), 50);
			index++;
			if (index == random_index) {
				throw new RuntimeException("throw exception");
			}				
		}
		
	}

	

	
}
