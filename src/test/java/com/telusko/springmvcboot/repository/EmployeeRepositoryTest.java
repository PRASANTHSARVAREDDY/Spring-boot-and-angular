package com.telusko.springmvcboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//whether the database or repository working fine or not
import com.telusko.springmvcboot.model.Employee;
@SpringBootTest
class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	Employee employee;

	@BeforeEach
	void setUp(){
		employee =new Employee(1,"sai","prasanth","sai@gmail.com");
		employeeRepository.save(employee);
	}

	@AfterEach
	void tearDown(){
	employee=null;
	employeeRepository.deleteAll();
	}

	@Test
	void testFindByFirstName_Found() {
		List<Employee> employeeList=employeeRepository.findByFirstName("sai");
		assertThat(employeeList.get(0).getLastName()).isEqualTo(employee.getLastName());
		assertThat(employeeList.get(0).getEmailId()).isEqualTo(employee.getEmailId());
	
	}
	@Test
	void testFindByFirstName_NotFound() {
		List<Employee> employeeList=employeeRepository.findByFirstName("gcp");
		assertThat(employeeList.isEmpty()).isTrue();
	
	}
	

}
