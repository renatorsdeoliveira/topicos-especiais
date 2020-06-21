import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmpresaListComponent } from './empresa-list/empresa-list.component';
import { CreateEmpresaComponent } from './create-empresa/create-empresa.component';
import { UpdateEmpresaComponent } from './update-empresa/update-empresa.component';
import { EmpresaDetailsComponent } from './empresa-details/empresa-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },
  { path: 'empresas', component: EmpresaListComponent },
  { path: 'addEmpresa', component: CreateEmpresaComponent },
  { path: 'updateEmpresa/:id', component: UpdateEmpresaComponent },
  { path: 'detailsEmpresa/:id', component: EmpresaDetailsComponent },
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
