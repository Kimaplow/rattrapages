import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, of, tap } from 'rxjs';
import { baseUrl } from '../app.component';
import { Personne } from '../classes/Personne';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private router: Router) { }

  login(personne: Object) {
    return this.http.post<Personne>(baseUrl + 'personnes/login', personne).pipe(
      tap(),
      catchError(error => {
        console.error(error)
        return of([])
      })
    )
  }

}
