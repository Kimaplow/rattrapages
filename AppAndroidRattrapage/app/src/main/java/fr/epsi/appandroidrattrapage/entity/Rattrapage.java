package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Rattrapage {

    @SerializedName("idRattrapage")
    private long idRattrapage;

    @SerializedName("sujet")
    private String sujet;

    /*
    @SerializedName("date")
    private Date date;

    @SerializedName("heure")

    @SerializedName("duree")
     */

    @SerializedName("matiere")
    private Matiere matiere;

    @SerializedName("salle")
    private Salle salle;

    @SerializedName("professeur")
    private Professeur professeur;

}
