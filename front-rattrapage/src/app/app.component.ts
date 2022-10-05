import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {

  }

  logout() {
    localStorage.removeItem("user");
    localStorage.clear();
    this.router.navigate([''])
  }

  clickRattrapages(){
    this.router.navigate(['rattrapages'])
  }

  clickProfesseurs(){
    this.router.navigate(['professeurs'])
  }

  clickSurveillants(){
    this.router.navigate(['surveillants'])
  }

  clickEleves(){
    this.router.navigate(['eleves'])
  }

}

export const baseUrl = "http://localhost:8080/v1/";
export const baseUrlPhotos = "http://localhost:8080/photos/";
export const baseUrlPdf = "http://localhost:8080/pdf/";