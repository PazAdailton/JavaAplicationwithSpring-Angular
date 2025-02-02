import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { EstudanteServiceService } from '../../service/estudante-service.service';

@Component({
  selector: 'app-lista-estudante',
  imports: [],
  templateUrl: './lista-estudante.component.html',
  styleUrl: './lista-estudante.component.css'
})
export class ListaEstudanteComponent {

      listaEstudantes:any [] = [];

      constructor(private estudanteService: EstudanteServiceService){
        
      }

      ngOnInit(){
        this.getEstudantes();
      }

      getEstudantes(){
          this.estudanteService.carregarTodosEstudantes().subscribe(
            (dados) => {
              this.listaEstudantes = dados;
            },
            (erro) => {
              console.error("Error ao buscar estudantes", erro)
            }
          )
        
      };
}
