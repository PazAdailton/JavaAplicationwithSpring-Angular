import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstudanteServiceService {
     

  constructor(private http: HttpClient) { 
  }
   
  carregarTodosEstudantes(): Observable<any[]> {
    return this.http.get<any[]>("http://localhost:8181/api/estudantes/listaestudante");
  }

 
};


