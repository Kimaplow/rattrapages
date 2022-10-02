import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RattrapageComponent } from './rattrapage/rattrapage/rattrapage.component';

const routes: Routes = [
  {
    path: "**",
    redirectTo: "rattrapages",
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
