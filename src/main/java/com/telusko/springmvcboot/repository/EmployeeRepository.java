package com.telusko.springmvcboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.springmvcboot.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByFirstName(String firstName);


}
