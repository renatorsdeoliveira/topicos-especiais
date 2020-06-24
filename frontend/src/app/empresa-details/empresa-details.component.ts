import { Empresa } from '../empresa';
import { Component, OnInit, Input } from '@angular/core';
import { EmpresaService } from '../empresa.service';
import { EmpresaListComponent } from '../empresa-list/empresa-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-empresa-details',
  templateUrl: './empresa-details.component.html',
  styleUrls: ['./empresa-details.component.css']
})
export class EmpresaDetailsComponent implements OnInit {

  id: number;
  empresa: Empresa;

  constructor(private route: ActivatedRoute,private router: Router,
    private empresaService: EmpresaService) { }

  ngOnInit() {
    this.empresa = new Empresa();

    this.id = this.route.snapshot.params['id'];
    
    this.empresaService.getEmpresa(this.id)
      .subscribe(data => {
        console.log(data)
        this.empresa = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['/empresas']);
  }
}
