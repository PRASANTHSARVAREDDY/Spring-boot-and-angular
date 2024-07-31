package com.telusko.springmvcboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springmvcboot.model.Employee;
import com.telusko.springmvcboot.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200") 
public class EmployeeController {
	
	@Autowired
 private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/employees/firstName/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstName){
		return employeeService.getEmployeeByFirstName(firstName);
	}
	@PostMapping("/employees")
	public String createEmployee( @RequestBody Employee employee) {
		 employeeService.save(employee);
		 return "Employee created succesfully";
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	@PutMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		employeeService.updateEmployee(id,employee);
		return "Success";
	}
	@DeleteMapping("/employees/{id}")
	public String delete(@PathVariable("id") int id) {
	   return employeeService.deleteEmployee(id);
	}
}
