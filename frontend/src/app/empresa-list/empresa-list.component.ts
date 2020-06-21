import { EmpresaDetailsComponent } from './../empresa-details/empresa-details.component';
import { Observable } from "rxjs";
import { EmpresaService } from "./../empresa.service";
import { Empresa } from "./../empresa";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-empresa-list",
  templateUrl: "./empresa-list.component.html",
  styleUrls: ["./empresa-list.component.css"]
})
export class EmpresaListComponent implements OnInit {
  empresas: Observable<Empresa[]>;

  constructor(private empresaService: EmpresaService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.empresas = this.empresaService.getEmpresasList();
  }

  deleteEmpresa(id: number) {
    this.empresaService.deleteEmpresa(id)

      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
      
        error => console.log(error));
  }

  empresaDetails(id: number){
    this.router.navigate(['detailsEmpresa', id]);
  }

  updateEmpresa(id: number){
    this.router.navigate(['updateEmpresa', id]);
  }
}
