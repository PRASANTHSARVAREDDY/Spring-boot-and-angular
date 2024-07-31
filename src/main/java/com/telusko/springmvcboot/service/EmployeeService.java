package com.telusko.springmvcboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.telusko.springmvcboot.exception.ResourceNotFoundException;
import com.telusko.springmvcboot.model.Employee;
import com.telusko.springmvcboot.repository.EmployeeRepository;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public String save( @RequestBody Employee employee) {
	 employeeRepository.save(employee);
	 return "Success";
	}

	public Employee getEmployeeById(int id) {
		Employee employee=employeeRepository.findById(id).orElse(null);
		return employee;
	}

	public String updateEmployee(int id, Employee employee) {
		Employee emp=employeeRepository.findById(id).orElse(null);
		if(emp!=null) {
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		 employeeRepository.save(emp);
		 return "Success"; 
		}
		else {
			return "Failed";
		}
	}

	public String deleteEmployee(int id) {
		Employee emp=employeeRepository.findById(id).orElse(null);
		if(emp!=null) {
			employeeRepository.delete(emp);
			return "employee Deleted Succesfully";
		}
		else {
		   return "employee not found";
		}
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
		
	}

}
