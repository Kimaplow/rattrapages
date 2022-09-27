package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

public class Personne {

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

    public Personne(String mail, String password){
        this.mail = mail;
        this.password = password;
    }

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
