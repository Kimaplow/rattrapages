import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    let u = localStorage.getItem("user");

    if (u !== null && u !== "undefined") {
      this.router.navigate(['rattrapages'])
    }
  }

  onSubmit(data: any) {
    event?.preventDefault();

    const p = {
      "mail": data.email,
      "password": data.password
    };

    this.loginService.login(p).subscribe(
      personne => (personne !== null ?
        localStorage.setItem("user", JSON.stringify(personne))
        : localStorage.setItem("user", "undefined")
      )
    )
    
    setTimeout(() => {
      this.ngOnInit()
    }, 500);
  }

}
