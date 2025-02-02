import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ListaEstudanteComponent } from '../componentes/lista-estudante/lista-estudante.component';


@Component({
  selector: 'app-root',
  imports: [RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'AngularSpring';
}
