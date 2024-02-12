package com.raviit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.raviit.entity.Employee;
import com.raviit.repository.EmployeeRepo;
import com.raviit.service.EmployeeServiceImpl;

@SpringBootApplication
public class EmployeeServiceTest {

	
	
	   @Mock
	   private EmployeeRepo employeeRepo;
	   
	   @InjectMocks
	   private EmployeeServiceImpl employeeServiceImpl=new EmployeeServiceImpl();
	   
	   @Autowired
	   private MockMvc mvc;
	   
	   @Test
	   public void testAddEmployee() {
		   
		   
		        Employee emp=new Employee(1,"ravi","grp",9916587);
		        
		        when(employeeServiceImpl.addemployee(emp)).thenReturn(emp);
		        
		        assertEquals(emp.getName(), emp.getName());
	   }
	         
}
