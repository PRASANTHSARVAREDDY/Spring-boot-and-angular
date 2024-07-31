package com.telusko.springmvcboot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.telusko.springmvcboot.model.Employee;
import com.telusko.springmvcboot.service.EmployeeService;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
	private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    Employee employeeOne;
    Employee employeeTwo;
    List<Employee> employeeList=new ArrayList<>();
    
	@BeforeEach
	void setUp() throws Exception {
		employeeOne=new Employee(1,"sai","prasanth","sai@gmail.com");
		employeeTwo=new Employee(2,"reddy","mawa","reddy@gmail.com");
		employeeList.add(employeeOne);
		employeeList.add(employeeTwo);
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void testGetAllEmployees() throws Exception {
		when(employeeService.getAllEmployees()).thenReturn(employeeList);
		this.mockMvc.perform(get("/api/v1/employees")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetEmployeeByFirstName() throws Exception {
		when(employeeService.getEmployeeByFirstName("sai")).thenReturn(employeeList);
		this.mockMvc.perform(get("/api/v1/employees/firstName/sai")).andDo(print()).andExpect(status().isOk());
	  
	}

	@Test
	void testCreateEmployee() throws Exception {
		 ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	        String requestJson=ow.writeValueAsString(employeeOne);
		when(employeeService.save(employeeOne)).thenReturn("Sucess");
		this.mockMvc.perform(post("/api/v1/employees").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testGetEmployeeById() throws Exception {
		when(employeeService.getEmployeeById(1)).thenReturn(employeeOne);
		this.mockMvc.perform(get("/api/v1/employees/1")).andDo(print()).andExpect(status().isOk());
	
	}

	@Test
	void testUpdateEmployee() throws Exception {
		 ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	        String requestJson=ow.writeValueAsString(employeeOne);
		when(employeeService.updateEmployee(1,employeeOne)).thenReturn("Sucess");
		this.mockMvc.perform(put("/api/v1/employees/1").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print()).andExpect(status().isOk());
	
	}
 
	@Test
	void testDelete() throws Exception {
	  when(employeeService.deleteEmployee(1)).thenReturn("employee Deleted Succesfully");
	  this.mockMvc.perform(delete("/api/v1/employees/1")).andDo(print()).andExpect(status().isOk());
	}

}
