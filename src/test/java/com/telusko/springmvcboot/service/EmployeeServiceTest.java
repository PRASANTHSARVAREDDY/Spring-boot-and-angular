package com.telusko.springmvcboot.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.telusko.springmvcboot.model.Employee;
import com.telusko.springmvcboot.repository.EmployeeRepository;
//whether the data is fetched correctly or not
@DataJpaTest
class EmployeeServiceTest {
	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
    EmployeeService employeeService;
	AutoCloseable autoCloseable;
	//The main of autocloseable is to close all unwanted resources when execution is completed
	Employee employee;
	@BeforeEach
	void setUp(){
		autoCloseable=MockitoAnnotations.openMocks(this);
		employee=new Employee(1,"sai","prasanth","sai@gmail.com");
	}

	@AfterEach
	void tearDown() throws Exception{
		autoCloseable.close();
	}

	@Test
	void testGetAllEmployees() {
		mock(Employee.class);
		mock(EmployeeRepository.class);
		when (employeeRepository.findAll()).thenReturn(new ArrayList<Employee>(Collections.singleton(employee)));
		assertThat(employeeService.getAllEmployees().get(0).getLastName()).isEqualTo(employee.getLastName());
      
	}

	@Test
	void testSave() {
	  mock(Employee.class);
	  mock(EmployeeRepository.class);
	  when(employeeRepository.save(employee)).thenReturn(employee);
	  assertThat(employeeService.save(employee)).isEqualTo("Success");
	}

	@Test
	void testGetEmployeeById() {
		mock(Employee.class);
		mock(EmployeeRepository.class);
		when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(employee));
		assertThat(employeeService.getEmployeeById(1).getFirstName()).isEqualTo(employee.getFirstName());
	
	}

	@Test
	void testUpdateEmployee() {
		 mock(Employee.class);
		  mock(EmployeeRepository.class);
		  when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(employee));
		  assertThat(employeeService.updateEmployee(1,employee)).isEqualTo("Success");
	}

	@Test
	void testDeleteEmployee() {
		mock(Employee.class);
		mock(EmployeeRepository.class);
		when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(employee));
		assertThat(employeeService.deleteEmployee(1)).isEqualTo("employee Deleted Succesfully");

	}

	@Test
	void testGetEmployeeByFirstName() {
		mock(Employee.class); 
		mock(EmployeeRepository.class);
		when(employeeRepository.findByFirstName("sai")).thenReturn(new ArrayList<Employee>(Collections.singleton(employee)));
		assertThat(employeeService.getEmployeeByFirstName("sai").get(0).getLastName()).isEqualTo(employee.getLastName());
		
	}

}
