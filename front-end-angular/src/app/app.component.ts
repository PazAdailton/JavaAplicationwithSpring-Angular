import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EstudanteComponent } from './CRUD/estudante/estudante.component';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, EstudanteComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'front-end-angular';
}
