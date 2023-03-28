package com.itwill.transaction.spring;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(
		propagation = Propagation.REQUIRED,
		isolation = Isolation.READ_COMMITTED,
		rollbackFor = RuntimeException.class)
public interface EmployeeService {

	public abstract void registerEmployee(Employee emp);
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public abstract void deleteEmployee(int id);
	//@Transactional(isolation = Isolation.SERIALIZABLE)
	public abstract void udpateEmployee(Employee emp);
	@Transactional(rollbackFor = {SQLException.class,RuntimeException.class},
				   noRollbackFor = IndexOutOfBoundsException.class)
	public abstract List<Employee> getEmps();
	
	public abstract void increaseSalaryForAll();
	
	

}