import { Component, OnInit } from '@angular/core';
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

  constructor(private rattrapageService: RattrapageService) { }

  ngOnInit(): void {
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

  onSubmit(data: any){
    /*
    date: "2022-10-12"
    duree: 120
    eleve1: "3"
    eleve2: "9"
    eleve3: "11"
    eleve4: "15"
    file: "C:\\fakepath\\Compte rendu du 03_10_2022.pdf"
    matiere: "3"
    nbrEleve: 4
    professeur: "3"
    salle: "1"
    surveillant: "6"
    time: "18:52"
    */
    console.log(data);

    //Parse id en number
    //ajouter etat et sujet

    let dataRattrapage = {
      "date": data.date,
      "heure": data.heure,
      "duree": data.duree,
      "professeur" : {
        "idPersonne" : data.professeur
      },
      "surveillant": {
        "idPersonne": data.surveillant
      },
      "matiere": {
        "idMatiere": data.matiere
      },
      "salle": {
        "idSalle": data.salle
      }
    };

    let rat: Rattrapage; 

    this.rattrapageService.postRattrapage(dataRattrapage).subscribe(
      rattrapage => {
        console.log(rattrapage);
        rat = rattrapage
      }
    )
    
  }

}
