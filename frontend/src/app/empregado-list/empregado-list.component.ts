import { EmpregadoDetailsComponent } from '../empregado-details/empregado-details.component';
import { Observable } from "rxjs";
import { EmpregadoService } from "./../empregado.service";
import { Empregado } from "./../empregado";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-empregado-list",
  templateUrl: "./empregado-list.component.html",
  styleUrls: ["./empregado-list.component.css"]
})
export class EmpregadoListComponent implements OnInit {
  empregados: Observable<Empregado[]>;

  constructor(private empregadoService: EmpregadoService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.empregados = this.empregadoService.getEmpregadosList();
  }

  deleteEmpregado(id: number) {
    this.empregadoService.deleteEmpregado(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  empregadoDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateEmpregado(id: number){
    this.router.navigate(['update', id]);
  }
}
