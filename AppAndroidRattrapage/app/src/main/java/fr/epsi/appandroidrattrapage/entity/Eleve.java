package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Eleve implements Serializable {

    @SerializedName("idEleve")
    private long idEleve;

    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("photo")
    private String photo;

    public long getIdEleve() {
        return idEleve;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhoto() {
        return photo;
    }
}
