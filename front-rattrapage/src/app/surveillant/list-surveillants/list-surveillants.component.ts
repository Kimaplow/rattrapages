import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Personne } from 'src/app/classes/Personne';
import { SurveillantService } from '../surveillant.service';

@Component({
  selector: 'app-list-surveillants',
  templateUrl: 'list-surveillants.component.html'
})
export class ListSurveillantsComponent implements OnInit {

  user: Personne;
  listSurveillants: Personne[];

  constructor(private router: Router, private serviceSurveillant: SurveillantService) { }

  ngOnInit(): void {
    let p = localStorage.getItem("user");
    if (p === null || p === "undefined") {
      this.router.navigate([""]);
    }
    else{
      this.user = JSON.parse(p!);
    }

    this.serviceSurveillant.getAllProfesseurs().subscribe(
      surveillants => this.listSurveillants = surveillants
    )

  }

}
