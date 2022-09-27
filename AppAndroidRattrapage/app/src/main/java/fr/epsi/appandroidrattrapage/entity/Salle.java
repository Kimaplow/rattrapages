package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

public class Salle {

    @SerializedName("nom")
    private String nom;

    @SerializedName("nbrPlace")
    private int nbrPlace;

    public String getNom() {
        return nom;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }
}
