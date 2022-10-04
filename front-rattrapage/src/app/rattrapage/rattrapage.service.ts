import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { baseUrl } from '../app.component';
import { Convocation } from '../classes/Convocation';
import { Eleve } from '../classes/Eleve';
import { Matiere } from '../classes/Matiere';
import { Personne } from '../classes/Personne';
import { Rattrapage } from '../classes/Rattrapage';
import { Salle } from '../classes/Salle';

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

  setElevePresent(idEleve: number, idRattrapage: number){
    return this.http.patch<Convocation>(baseUrl + "convocations/rattrapage/" + idRattrapage + "/eleve/" + idEleve + "/present", {}).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getAllSalles(){
    return this.http.get<Salle[]>(baseUrl + "salles").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getAllMatieres(){
    return this.http.get<Matiere[]>(baseUrl + "matieres").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getAllPersonnesByRole(role: string){
    return this.http.get<Personne[]>(baseUrl + "personnes/role/" + role).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  getAllEleve(){
    return this.http.get<Eleve[]>(baseUrl + "eleves").pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of([])
      })
    )
  }

  postRattrapage(data: Object){
    return this.http.post<Rattrapage>(baseUrl + "rattrapages", data).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of()
      })
    )
  }

  postConvocation(data: Object){
    return this.http.post<Convocation>(baseUrl + "convocations", data).pipe(
      tap(),
      catchError(error => {
        console.error(error);
        return of()
      })
    )
  }

}
