package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeList {

	@Autowired
	Employee emp;
	
	public Employee getEmp() {
		return emp;
	}
	
}
