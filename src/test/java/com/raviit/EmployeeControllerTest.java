package com.raviit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.raviit.controller.EmployeeController;
import com.raviit.entity.Employee;
import com.raviit.service.EmployeeService;

@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

	@MockBean
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockmvc;

	
	@Test
	public void testAddEmployee() throws Exception {

		Employee emp = new Employee(1, "John Doe", "bangalore", 99757367);
		when(employeeService.addemployee(Mockito.any(Employee.class))).thenReturn(emp);

		ResultActions andExpect = mockmvc
				.perform(MockMvcRequestBuilders.post("/addemployee").contentType(MediaType.APPLICATION_JSON)
						.content("{\"json\":\"request to be send\"}"))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("bangalore"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phno").value("99757367"));
		

		assertEquals(200, andExpect);
	}

	@Test
	public void testfetchemployee() throws Exception {
		
		    Employee emp=new Employee(1,"ravi","bangalore",99165876);
		    Employee emp1=new Employee(2,"rohit","mumbai",87872832);
		    Employee emp2=new Employee(3,"rahul","pune",768272832);
		    List<Employee> list=new ArrayList<>();
		    list.add(emp2);
		    list.add(emp1);
		    list.add(emp);
		    when(employeeService.fetchemployee()).thenReturn(list);
		    
		    MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.get("/fetch");
		    
		    MvcResult andReturn = mockmvc.perform(builder).andReturn();
		    
		    MockHttpServletResponse response = andReturn.getResponse();
		    int status = response.getStatus();
		    assertEquals(200,status);
	}


}
