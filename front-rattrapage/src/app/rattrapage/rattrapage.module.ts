import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { RattrapageComponent } from './rattrapage/rattrapage.component';
import { DetailsRattrapageComponent } from './details-rattrapage/details-rattrapage.component';
import { FormsModule } from '@angular/forms';
import { DisabledPipe } from './disabled.pipe';

const routes: Routes = [
  {
    path: 'rattrapages',
    component: RattrapageComponent
  },
  {
    path: 'rattrapages/:id',
    component: DetailsRattrapageComponent
  }
]

@NgModule({
  declarations: [
    RattrapageComponent,
    DetailsRattrapageComponent,
    DisabledPipe
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild(routes)
  ]
})
export class RattrapageModule { }
