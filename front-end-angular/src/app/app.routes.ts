import { Routes } from '@angular/router';
import { EstudanteComponent } from './CRUD/estudante/estudante.component';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: '', redirectTo: 'api/estudantes', pathMatch: 'full' },  
    { path: 'estudantes', component: EstudanteComponent},  
    { path: 'api', component: EstudanteComponent }  ];
    
 