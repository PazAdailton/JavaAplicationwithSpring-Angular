import { Routes } from '@angular/router';
import { ListaEstudanteComponent } from '../componentes/lista-estudante/lista-estudante.component';
import { AddEstudantesComponent } from '../componentes/add-estudantes/add-estudantes.component';

export const routes: Routes = [
    {   path:"",
        redirectTo: 'lista-estudante',
        pathMatch: 'full'
    },
    {
        path: 'lista-estudante',
        component: ListaEstudanteComponent
    },
    {
        path: 'add-estudantes',
        component: AddEstudantesComponent
    }
];

export class appRoutingModule{}