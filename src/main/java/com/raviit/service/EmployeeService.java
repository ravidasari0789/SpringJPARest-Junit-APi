package com.raviit.service;

import java.util.List;

import com.raviit.entity.Employee;

public interface EmployeeService {

	         public Employee addemployee(Employee emp);
	         public List<Employee> fetchemployee();
	         public Employee updateemployee(Employee id);
	         
	         public void deleteemployee(Long id);
}
