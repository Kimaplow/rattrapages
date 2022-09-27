package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Personne implements Serializable {

    @SerializedName("idPersonne")
    private long idPersonne;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("nom")
    private String nom;

    @SerializedName("mail")
    private String mail;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    public long getIdPersonne() {
        return idPersonne;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
