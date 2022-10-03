import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, of, tap } from 'rxjs';
import { baseUrlPhotos } from 'src/app/app.component';
import { Convocation } from 'src/app/classes/Convocation';
import { Personne } from 'src/app/classes/Personne';
import { Rattrapage } from 'src/app/classes/Rattrapage';
import { RattrapageService } from '../rattrapage.service';

@Component({
  selector: 'app-details-rattrapage',
  templateUrl: 'details-rattrapage.component.html'
})
export class DetailsRattrapageComponent implements OnInit {

  rattrapage: Rattrapage;
  convocations: Convocation[];
  user: Personne;
  urlPhoto: string = baseUrlPhotos;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private rattrapageService: RattrapageService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.rattrapageService.getRattrapageById(+id).subscribe(
        rat => {
          this.rattrapage = rat
        }
      )
      this.rattrapageService.getConvocationsByRattrapage(+id).subscribe(
        convoc => this.convocations = convoc.sort((a, b ) => a.id.idEleve < b.id.idEleve ? -1 : 1)
      )
      let p = localStorage.getItem("user");
      if (p === null || p === "undefined") {
        this.router.navigate([""]);
      }
      else {
        this.user = JSON.parse(p!);
      }

    }

  }

  goToRattrapages() {
    this.router.navigate(['rattrapages'])
  }

  noteEleve(idEleve: number, idRattrapage: number, data: any) {
    this.rattrapageService.setNote(idEleve, idRattrapage, data.note).subscribe();
    setTimeout(() => {
      window.location.reload();
    }, 100);
    
  }

  setEtatRattrapage(id: number){
    let etat: string = this.rattrapage.etat === 'Non effectué' ? "Effectué mais non noté" : "Effectué et noté";
    this.rattrapageService.setEtatRattrapage(id, etat).subscribe();
    setTimeout(() => {
      window.location.reload();
    }, 100);
  }

  setPresent(idEleve: number, idRattrapage: number){
    console.log(idEleve);
    console.log(idRattrapage);
    this.rattrapageService.setElevePresent(idEleve, idRattrapage).subscribe();
    setTimeout(() => {
      window.location.reload();
    }, 100);
  }

}
