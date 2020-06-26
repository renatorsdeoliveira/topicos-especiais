import { EmpregadoDetailsComponent } from './empregado-details/empregado-details.component';
import { CreateEmpregadoComponent } from './create-empregado/create-empregado.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpregadoListComponent } from './empregado-list/empregado-list.component';
// import {EmpresaListComponent}
import { UpdateEmpregadoComponent } from './update-empregado/update-empregado.component';
import { EmpresaListComponent } from './empresa-list/empresa-list.component';
import { CreateEmpresaComponent } from './create-empresa/create-empresa.component';
import { UpdateEmpresaComponent } from './update-empresa/update-empresa.component';
import { EmpresaDetailsComponent } from './empresa-details/empresa-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'empregado', pathMatch: 'full' },
  { path: 'empregados', component: EmpregadoListComponent },
  { path: 'add', component: CreateEmpregadoComponent },
  { path: 'update/:id', component: UpdateEmpregadoComponent },
  { path: 'details/:id', component: EmpregadoDetailsComponent },
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
