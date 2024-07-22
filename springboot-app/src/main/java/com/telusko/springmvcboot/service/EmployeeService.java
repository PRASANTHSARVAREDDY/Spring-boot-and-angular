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

	public Employee save( @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Long id) {
		Employee employee=employeeRepository.findById(id).orElse(null);
		return employee;
	}

	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp=employeeRepository.findById(id).orElse(null);
		if(emp!=null) {
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		return employeeRepository.save(emp);
		}
		else {
			return null;
		}
	}

	public String deleteEmployee(Long id) {
		Employee emp=employeeRepository.findById(id).orElse(null);
		if(emp!=null) {
			employeeRepository.delete(emp);
			return "employee Deleted Succesfully";
		}
		else {
		   return "employee not found";
		}
	}

}
