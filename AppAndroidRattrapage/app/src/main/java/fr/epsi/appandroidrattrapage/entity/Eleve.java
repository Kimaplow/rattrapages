package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

public class Eleve {

    @SerializedName("idEleve")
    private long id;

    @SerializedName("nom")
    private String nom;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("photo")
    private String photo;

}
