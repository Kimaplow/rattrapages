import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EleveModule } from './eleve/eleve.module';
import { LoginModule } from './login/login.module';
import { ProfesseurModule } from './professeur/professeur.module';
import { RattrapageModule } from './rattrapage/rattrapage.module';
import { SurveillantModule } from './surveillant/surveillant.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LoginModule,
    RattrapageModule,
    ProfesseurModule,
    SurveillantModule,
    EleveModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
