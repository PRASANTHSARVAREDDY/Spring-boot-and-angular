import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiUrl=environment.apiUrl;

  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>(this.apiUrl);
    
  }
  createEmployee(employee:Employee):Observable<Employee>{
    return this.http.post<Employee>(this.apiUrl,employee);
  }
  getEmployeeById(id:number):Observable<Employee>{
    return this.http.get<Employee>(`${this.apiUrl}/${id}`);
   }
   updateEmployee(id:number,employee:Employee):Observable<object>{
    return this.http.put(`${this.apiUrl}/${id}`,employee)
   }
   deleteEmployee(id:number):Observable<Object>{
    return this.http.delete(`${this.apiUrl}/${id}`);
   }
}
