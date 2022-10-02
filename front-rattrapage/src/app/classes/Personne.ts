import { Rattrapage } from "./Rattrapage";

export class Personne {
    idPersonne: number;
    nom: string;
    prenom: string;
    mail: string;
    password: string;
    role: string;
    rattrapagesSurveillant: Array<Rattrapage>;
    rattrapagesProfesseur: Array<Rattrapage>;
}