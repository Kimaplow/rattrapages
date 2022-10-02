import { Time } from "@angular/common";
import { Matiere } from "./Matiere";
import { Personne } from "./Personne";
import { Salle } from "./Salle";

export class Rattrapage {
    idRattrapage: number;
    sujet: string;
    date: Date;
    heure: Time;
    duree: number;
    etat: string;
    matiere: Matiere;
    salle: Salle;
    professeur: Personne;
    surveillant: Personne;
}