import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

  navbar: boolean;

  constructor(private router: Router){}

  ngOnInit(){
    setTimeout(() => {
      let u = localStorage.getItem("user");
      console.log(u);
      
      if (u == null && u == "undefined") {
        this.navbar = true
      }
      else{
        this.navbar = false;
      }
      console.log(this.navbar);
    }, 200);
    

    
  }

}

export const baseUrl = "http://localhost:8080/v1/";
export const baseUrlPhotos = "http://localhost:8080/photos/";
export const baseUrlPdf = "http://localhost:8080/pdf/";