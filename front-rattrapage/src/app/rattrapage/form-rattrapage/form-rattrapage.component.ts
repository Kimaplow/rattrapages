import { Time } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Eleve } from 'src/app/classes/Eleve';
import { Matiere } from 'src/app/classes/Matiere';
import { Personne } from 'src/app/classes/Personne';
import { Rattrapage } from 'src/app/classes/Rattrapage';
import { Salle } from 'src/app/classes/Salle';
import { RattrapageService } from '../rattrapage.service';

@Component({
  selector: 'app-form-rattrapage',
  templateUrl: 'form-rattrapage.component.html'
})
export class FormRattrapageComponent implements OnInit {

  listSalles: Salle[];
  listMatiere: Matiere[];
  listProfesseurs: Personne[];
  listSurveillant: Personne[];
  listEleves: Eleve[];

  constructor(private rattrapageService: RattrapageService, private router: Router) { }

  ngOnInit(): void {
    let p = localStorage.getItem("user");
    if (p === null || p === "undefined") {
      this.router.navigate([""]);
    }
    
    this.rattrapageService.getAllSalles().subscribe(
      salles => this.listSalles = salles
    );

    this.rattrapageService.getAllMatieres().subscribe(
      matieres => this.listMatiere = matieres
    );

    this.rattrapageService.getAllPersonnesByRole("professeur").subscribe(
      professeurs => this.listProfesseurs = professeurs
    );

    this.rattrapageService.getAllPersonnesByRole("surveillant").subscribe(
      surveillants => this.listSurveillant = surveillants
    );

    this.rattrapageService.getAllEleve().subscribe(
      eleves => this.listEleves = eleves
    );

  }

  onSubmit(data: any) {

    let dataRattrapage = {
      "date": data.date,
      "heure": data.time,
      "duree": data.duree,
      "professeur": {
        "idPersonne": parseInt(data.professeur)
      },
      "surveillant": {
        "idPersonne": parseInt(data.surveillant)
      },
      "matiere": {
        "idMatiere": parseInt(data.matiere)
      },
      "salle": {
        "idSalle": parseInt(data.salle)
      }
    };

    this.rattrapageService.postRattrapage(dataRattrapage).subscribe(
      rattrapage => {
        for (let i: number = 1; i <= parseInt(data.nbrEleve); i++) {
          let dataConvoc = {
            "id": {
              "idRattrapage": rattrapage.idRattrapage,
              "idEleve": parseInt(eval(`data.eleve${i}`))
            },
            "eleve": {
              "idEleve": parseInt(eval(`data.eleve${i}`))
            },
            "rattrapage": {
              "idRattrapage": rattrapage.idRattrapage
            }
          };
          console.log(dataConvoc);
          this.rattrapageService.postConvocation(dataConvoc).subscribe()
        }
      }
    )

    setTimeout(() => {
      this.router.navigate(['rattrapages'])
    }, 50);

  }

}
