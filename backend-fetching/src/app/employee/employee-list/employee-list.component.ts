import { Component,OnInit} from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../../models/employee';
import {Router} from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent implements OnInit {
  employee:Employee[]=[]
  constructor(private employeeService:EmployeeService,private router:Router){}
  ngOnInit(): void {
    this.getEmployees();    
  }
  private getEmployees(){
    this.employeeService.getEmployees().subscribe(data=>{
      this.employee=data;
     });
  }
  updateEmployee(empId:number){
          this.router.navigate(['update-employee',empId]);
  }
  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      this.getEmployees();
    })
  }
  employeeDetails(empId:number){
    this.router.navigate(['employee-details',empId]);
  }  

}
