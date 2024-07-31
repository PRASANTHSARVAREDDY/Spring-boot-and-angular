import { Component, OnInit } from '@angular/core';
import { Employee } from '../../models/employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { response } from 'express';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent implements OnInit{
   
  employee:Employee=new Employee();
constructor(private employeeService:EmployeeService,private router:Router){}
  ngOnInit(): void {
    
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(response=>{
      console.log('Success:',response);},
    error=>{
      console.error('Error',error)
    });
      this.goToEmployeeList();
  }
  goToEmployeeList(){
    this.router.navigate(['/employee']);
  }
  OnSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}
