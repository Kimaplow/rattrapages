import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListElevesComponent } from './list-eleves/list-eleves.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'eleves',
    component: ListElevesComponent
  }
]

@NgModule({
  declarations: [
    ListElevesComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class EleveModule { }
