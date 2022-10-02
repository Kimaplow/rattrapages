import { Time } from "@angular/common";
import { Eleve } from "./Eleve";
import { KeyConvocation } from "./KeyConvocation";
import { Rattrapage } from "./Rattrapage";

export class Convocation {
    id: KeyConvocation;
    note: number;
    present: boolean;
    heureRendu: Time;
    eleve: Eleve;
    rattrapage: Rattrapage;
}