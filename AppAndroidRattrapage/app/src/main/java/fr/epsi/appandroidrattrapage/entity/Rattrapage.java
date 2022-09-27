package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

public class Rattrapage {

    @SerializedName("idRattrapage")
    private long idRattrapage;

    @SerializedName("sujet")
    private String sujet;

    //todo date/heure

    @SerializedName("duree")
    private int duree;

    @SerializedName("matiere")
    private Matiere matiere;

    @SerializedName("salle")
    private Salle salle;

    @SerializedName("professeur")
    private Personne personne;

    public long getIdRattrapage() {
        return idRattrapage;
    }

    public String getSujet() {
        return sujet;
    }

    public int getDuree() {
        return duree;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public Salle getSalle() {
        return salle;
    }

    public Personne getPersonne() {
        return personne;
    }
}
