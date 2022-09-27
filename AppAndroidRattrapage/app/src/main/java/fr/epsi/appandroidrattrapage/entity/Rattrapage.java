package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Rattrapage implements Serializable {

    @SerializedName("idRattrapage")
    private long idRattrapage;

    @SerializedName("sujet")
    private String sujet;

    @SerializedName("date")
    private String date;

    @SerializedName("heure")
    private String heure;

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

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
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
