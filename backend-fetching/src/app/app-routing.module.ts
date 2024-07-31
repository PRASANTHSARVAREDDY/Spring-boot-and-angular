import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee/employee-details/employee-details.component';

const routes: Routes = [
  {path:'',redirectTo:'employee',pathMatch:'full'},
  {path:'employee', component:EmployeeListComponent},
  {path:'create-employee',component:CreateEmployeeComponent},
  {path:'update-employee/:id',component:UpdateEmployeeComponent},
  {path:'employee-details/:id',component:EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
