import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Personne } from 'src/app/classes/Personne';
import { ProfesseurService } from '../professeur.service';

@Component({
  selector: 'app-list-professeurs',
  templateUrl: 'list-professeurs.component.html'
})
export class ListProfesseursComponent implements OnInit {

  listProfesseurs: Personne[];
  user: Personne;

  constructor(private router: Router, private serviceProfesseur: ProfesseurService) { }

  ngOnInit(): void {
    let p = localStorage.getItem("user");
    if (p === null || p === "undefined") {
      this.router.navigate([""]);
    }
    else{
      this.user = JSON.parse(p!);
    }

    this.serviceProfesseur.getAllProfesseurs().subscribe(
      professeurs => this.listProfesseurs = professeurs
    )

  }

}
