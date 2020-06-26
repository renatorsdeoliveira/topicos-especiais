import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmpregadoComponent } from './create-empregado/create-empregado.component';
import { EmpregadoDetailsComponent } from './empregado-details/empregado-details.component';
import { EmpregadoListComponent } from './empregado-list/empregado-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmpregadoComponent } from './update-empregado/update-empregado.component';
import { CreateEmpresaComponent } from './create-empresa/create-empresa.component';
import { EmpresaDetailsComponent } from './empresa-details/empresa-details.component';
import { EmpresaListComponent } from './empresa-list/empresa-list.component';
import { UpdateEmpresaComponent } from './update-empresa/update-empresa.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateEmpregadoComponent,
    EmpregadoDetailsComponent,
    EmpregadoListComponent,
    UpdateEmpregadoComponent,
    CreateEmpresaComponent,
    EmpresaDetailsComponent,
    EmpresaListComponent,
    UpdateEmpresaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
