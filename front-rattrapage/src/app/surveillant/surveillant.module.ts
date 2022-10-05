import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListSurveillantsComponent } from './list-surveillants/list-surveillants.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'surveillants',
    component: ListSurveillantsComponent
  }
]

@NgModule({
  declarations: [
    ListSurveillantsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class SurveillantModule { }
