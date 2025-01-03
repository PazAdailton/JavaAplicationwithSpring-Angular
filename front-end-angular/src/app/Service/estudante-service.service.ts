import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Estudante } from '../estudante';

@Injectable({
  providedIn: 'root'
})
export class EstudanteServiceService {

  private baseUrl = 'http://localhost:8080/api/estudantes/';
  
  constructor(private http:HttpClient) { }

  buscarTodosEstudantes():Observable<any>{
    return this.http.get(`${this.baseUrl}`+'listaestudante');
  }

  salvarEstudante(estudante:Estudante):Observable<any>{
    return this.http.post(`${this.baseUrl}salvarestudante`, estudante)
  }

  excluirEstudante(id: number):Observable<any>{
    return this.http.delete(`${this.baseUrl}excluirEstudante/${id}`, {responseType:'text'});
  }

  buscarPorID(id: number):Observable<any>{
    return this.http.get(`${this.baseUrl}estudante/${id}`);
  }

  alterarEstudante(id: number, value:any):Observable<Object>{
    return this.http.put(`${this.baseUrl}alterarestudante/${id}`, value);
  }

}
