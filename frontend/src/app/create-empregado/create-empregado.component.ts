import { EmpregadoService } from '../empregado.service';
import { Empregado } from '../empregado';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-empregado',
  templateUrl: './create-empregado.component.html',
  styleUrls: ['./create-empregado.component.css']
})
export class CreateEmpregadoComponent implements OnInit {

  empregado: Empregado = new Empregado();
  submitted = false;

  constructor(private empregadoService: EmpregadoService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmpregado(): void {
    this.submitted = false;
    this.empregado = new Empregado();
  }

  save() {
    this.empregadoService.createEmpregado(this.empregado)
      .subscribe(data => console.log(data), error => console.log(error));
    this.empregado = new Empregado();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/empregados']);
  }
}
