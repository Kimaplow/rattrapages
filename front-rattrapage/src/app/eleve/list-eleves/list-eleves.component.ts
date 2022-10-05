import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { baseUrlPhotos } from 'src/app/app.component';
import { Eleve } from 'src/app/classes/Eleve';
import { Personne } from 'src/app/classes/Personne';
import { EleveService } from '../eleve.service';

@Component({
  selector: 'app-list-eleves',
  templateUrl: 'list-eleves.component.html'
})
export class ListElevesComponent implements OnInit {

  user: Personne;
  listEleves: Eleve[];
  urlPhoto: string = baseUrlPhotos;

  constructor(private router: Router, private serviceEleve: EleveService) { }

  ngOnInit(): void {
    let p = localStorage.getItem("user");
    if (p === null || p === "undefined") {
      this.router.navigate([""]);
    }
    else{
      this.user = JSON.parse(p!);
    }

    this.serviceEleve.getAllEleves().subscribe(
      eleves => this.listEleves = eleves
    )

  }

}
