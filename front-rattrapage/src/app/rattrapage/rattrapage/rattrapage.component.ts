import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { baseUrlPdf } from "src/app/app.component";
import { Personne } from "src/app/classes/Personne";
import { Rattrapage } from "src/app/classes/Rattrapage";
import { RattrapageService } from "../rattrapage.service";

@Component({
  selector: "app-rattrapage",
  templateUrl: "rattrapage.component.html",
})
export class RattrapageComponent implements OnInit {
  user: Personne;
  rattrapages: Rattrapage[];
  urlPdf: string = baseUrlPdf;

  constructor(private router: Router, private rattrapageService: RattrapageService) { }

  ngOnInit(): void {
    let p = localStorage.getItem("user");   
    if (p === null || p === "undefined") {
      this.router.navigate([""]);
    }
    else {
      this.user = JSON.parse(p!);
      if (this.user.role == "surveillant") {
        this.rattrapageService.getRattrapageBySurveillant(this.user.idPersonne).subscribe(
          listRattrapages => this.rattrapages = listRattrapages
        );
      } else if (this.user.role == "professeur") {
        this.rattrapageService.getRattrapageByProfesseur(this.user.idPersonne).subscribe(
          listRattrapages => this.rattrapages = listRattrapages
        );
      } else {
        this.rattrapageService.getAllRattrapage().subscribe(
          listRattrapages => this.rattrapages = listRattrapages
        );
      }
    }
  }

  goToDetailRattrapage(id: number) {
    this.router.navigate(['rattrapages', id])
  }

}
