import { Empregado } from './empregado';
import { EmpregadoDetailsComponent } from './empregado-details/empregado-details.component';

export class Empresa{

  id: number;
  nomeEmpresa: string;
  cnpjEmpresa: string;
  telefone: string;
  endereco: string;
  dataFundacao: Date;
  proprietario: EmpregadoDetailsComponent;
  active: boolean;

}
