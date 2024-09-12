package com.example.demo.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeTest {

	@Autowired
	EmployeeList emplist;
	
	@Autowired
	Employee emp;
	
	@Test
	void work() {
		System.out.println("회사원이 일을 한다");
		System.out.println(emp);
		System.out.println(emplist.getEmp());
	}
	
}
