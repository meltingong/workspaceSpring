package com.itwill.annotation.exe;

@Component
@ComponentSingleValue(id=100)
@ComponentMultiValue(count = 10,names = {"KIM","SIM","JIM"}, print = true)
public class ComponentUsingClass {
	@AutoWierd
	private Object member;

	@AutoWierd
	public ComponentUsingClass(Object member) {
		
	}
	
	@AutoWierd
	public void method1(Object member) {
		
	}
	
	
	public void method2(@AutoWierd Object member) {
		
	}
}
