import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, of, tap } from 'rxjs';
import { baseUrl } from '../app.component';
import { Eleve } from '../classes/Eleve';
import { Personne } from '../classes/Personne';

@Injectable({
  providedIn: 'root'
})
export class EleveService {

  constructor(private http: HttpClient) { }

  getAllEleves(){
    return this.http.get<Eleve[]>(baseUrl + "eleves").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }
}
