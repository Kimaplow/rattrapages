import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, of, tap } from 'rxjs';
import { baseUrl } from '../app.component';
import { Personne } from '../classes/Personne';

@Injectable({
  providedIn: 'root'
})
export class ProfesseurService {

  constructor(private http: HttpClient) { }

  getAllProfesseurs(){
    return this.http.get<Personne[]>(baseUrl + "personnes/role/professeur").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }
}
