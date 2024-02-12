package com.raviit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raviit.entity.Employee;
import com.raviit.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public Employee addemployee(Employee emp) {
		
		Employee save = employeeRepo.save(emp);
		return save;
	}

	@Override
	public List<Employee> fetchemployee() {
		// TODO Auto-generated method stub
		
		List<Employee> findAll = employeeRepo.findAll();
	
		return findAll;
	}

	@Override
	public Employee updateemployee(Employee emp) {
	
		Employee save = employeeRepo.save(emp);
		return save;
	}

	@Override
	public void deleteemployee(Long id) {
		employeeRepo.deleteById(id);
		
	}

}
