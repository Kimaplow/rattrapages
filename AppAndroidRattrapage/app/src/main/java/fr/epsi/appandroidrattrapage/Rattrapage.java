package fr.epsi.appandroidrattrapage;

import java.io.Serializable;

public class Rattrapage implements Serializable {

    private String codeMatiere;
    private String matiere;
    private String professeur;
    private String salle;
    private String date;
    private String heure;

    public Rattrapage(String codeMatiere, String matiere, String professeur, String salle, String date, String heure) {
        this.codeMatiere = codeMatiere;
        this.matiere = matiere;
        this.professeur = professeur;
        this.salle = salle;
        this.date = date;
        this.heure = heure;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public String getProfesseur() {
        return professeur;
    }

    public String getSalle() {
        return salle;
    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }
}
