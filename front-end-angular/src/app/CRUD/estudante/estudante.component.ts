import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { EstudanteServiceService } from '../../Service/estudante-service.service';
import { Estudante } from '../../estudante';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-estudante',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  templateUrl: './estudante.component.html',
  styleUrl: './estudante.component.scss'
})
export class EstudanteComponent implements OnInit {

      estudantes: Estudante[] = [];
      novoEstudante: Estudante = {nome: '', email: '', categoriaEstudantil: '' }
      editandoEstudante: Estudante | null = null;

      constructor(private estudanteService: EstudanteServiceService){}
      ngOnInit(): void {
        this.carregarEstudantes();
      }

      carregarEstudantes(): void {
        this.estudanteService.buscarTodosEstudantes().subscribe(
          data =>{ this.estudantes = data},
          error =>{console.log("Erro ao carregar lista", error) } )
      }
      
      salvar(): void{
        this.estudanteService.salvarEstudante(this.novoEstudante).subscribe(
          data => {
            console.log("Salvo com sucesso", data)
            this.carregarEstudantes();
            this.novoEstudante = {nome: '', email: '', categoriaEstudantil: '' }
          },
          error => {console.log("Erro ao salvar", error)
          });
        }
        
      excluir(id: number): void{
        this.estudanteService.excluirEstudante(id).subscribe(
          data => {
            console.log("Excluído com sucesso", data);
            this.carregarEstudantes();
          },
          error => {console.log("Erro ao excluir", error);
          })
          };

      buscarPorId(id: number){
        this.estudanteService.buscarPorID(id).subscribe(
          (data: Estudante) =>{
            this.editandoEstudante = data;
            this.novoEstudante = {...data};
          },
          error =>{console.log("Erro ao buscar estudante", error)
          });
          }
          
        atualizar(){
          if(this.editandoEstudante){
          this.estudanteService.alterarEstudante(this.editandoEstudante.id!, this.novoEstudante).subscribe(
            (data) => {
              console.log("Estudante atualizado com sucesso", data);
              this.carregarEstudantes();
              this.novoEstudante = { nome: '', email: '', categoriaEstudantil: '' };
              this.editandoEstudante = null;
            },
            (error) =>{
              console.error("Erro ao atualizar estudante: ", error);
            });
            } //if
            } //atualizar
            
            cancelarEdicao(): void {
              this.novoEstudante = { nome: '', email: '', categoriaEstudantil: '' };
              this.editandoEstudante = null;
            }
    
    
    }
