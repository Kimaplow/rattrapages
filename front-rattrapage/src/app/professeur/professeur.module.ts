import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListProfesseursComponent } from './list-professeurs/list-professeurs.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'professeurs',
    component: ListProfesseursComponent
  }
]

@NgModule({
  declarations: [
    ListProfesseursComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class ProfesseurModule { }
