import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { baseUrl } from '../app.component';
import { Convocation } from '../classes/Convocation';
import { Personne } from '../classes/Personne';
import { Rattrapage } from '../classes/Rattrapage';

@Injectable({
  providedIn: 'root'
})
export class RattrapageService {

  constructor(private http: HttpClient) { }

  getRattrapageBySurveillant(id: number): Observable<Rattrapage[]>{
    return this.http.get<Rattrapage[]>(baseUrl + "rattrapages/surveillant/" + id).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getRattrapageByProfesseur(id: number){
    return this.http.get<Rattrapage[]>(baseUrl + "rattrapages/professeur/" + id).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getAllRattrapage(){
    return this.http.get<Rattrapage[]>(baseUrl + "rattrapages").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getRattrapageById(id: number){
    return this.http.get<Rattrapage>(baseUrl + "rattrapages/" + id).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of()
      })
    )
  }

  getConvocationsByRattrapage(idRattrapage: number){
    return this.http.get<Convocation[]>(baseUrl + "convocations/rattrapage/" + idRattrapage + "/eleves").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  setNote(idEleve: number, idRattrapage: number, note: number){
    let n = {
      "note" : note
    };
    return this.http.patch<Convocation>(baseUrl + "convocations/rattrapage/" + idRattrapage + "/eleve/" + idEleve + "/note", n).pipe(
      tap(),
      catchError(error => {
        console.error(error)
        return of([])
      })
    )
  }

  setEtatRattrapage(id: number, etat: string){
    let e = {
      "etat": etat
    }
    return this.http.patch<Rattrapage>(baseUrl + "rattrapages/" + id + "/etat", e).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of()
      })
    )

  }

}
