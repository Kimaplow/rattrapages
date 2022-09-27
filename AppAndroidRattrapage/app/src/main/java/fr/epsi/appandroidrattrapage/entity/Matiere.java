package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

public class Matiere {

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
