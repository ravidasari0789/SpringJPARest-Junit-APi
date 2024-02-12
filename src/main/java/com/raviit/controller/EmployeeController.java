package com.raviit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raviit.entity.Employee;
import com.raviit.service.EmployeeService;

@RestController
public class EmployeeController {

	          @Autowired
	          private EmployeeService employeeService;
	          
	          @PostMapping("/addemployee")
	          public ResponseEntity<Employee> addemployee(@RequestBody Employee emp){
	        	  
	        	  Employee addemployee = employeeService.addemployee(emp);
	        	  
	        	  return new ResponseEntity<Employee>(addemployee,HttpStatus.CREATED);
	          }
	          @GetMapping("/fetch")
	          public ResponseEntity<List<Employee>> fetchemployee(){
	        	  
	        	  List<Employee> fetchemployee = employeeService.fetchemployee();
	        	  
	        	  return new ResponseEntity<List<Employee>>(fetchemployee,HttpStatus.OK);
	          }
	          @PutMapping("/update")
	          public ResponseEntity<Employee> updateemployee(@RequestBody Employee emp){
	        	  
	        	  Employee updateemployee = employeeService.updateemployee(emp);
	        	  
	        	  return new ResponseEntity<Employee>(updateemployee,HttpStatus.ACCEPTED);
	          }
	          @DeleteMapping("/delete/{id}")
	          public void deleteemployee(@PathVariable("id") Long id){
	        	  
	        	  employeeService.deleteemployee(id);
	          }
}

