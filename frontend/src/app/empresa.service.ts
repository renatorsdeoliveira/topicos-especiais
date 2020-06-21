import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/empresas';

  constructor(private http: HttpClient) { }

  getEmpresa(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEmpresa(empresa: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, empresa);
  }

  updateEmpresa(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmpresa(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmpresasList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
