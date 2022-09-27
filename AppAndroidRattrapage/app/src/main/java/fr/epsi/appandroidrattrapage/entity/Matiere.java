package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Matiere implements Serializable {

    @SerializedName("idMatiere")
    private long idMatiere;

    @SerializedName("code")
    private String code;

    @SerializedName("libelle")
    private String libelle;

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }
}
