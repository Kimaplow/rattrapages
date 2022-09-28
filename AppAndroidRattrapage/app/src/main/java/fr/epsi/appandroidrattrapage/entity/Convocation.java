package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Convocation implements Serializable {

    @SerializedName("id")
    private ConvocationKey key;

    @SerializedName("eleve")
    private Eleve eleve;

    @SerializedName("present")
    private boolean present;

    @SerializedName("heureRendu")
    private String heureRendu;

    public ConvocationKey getKey() {
        return key;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public boolean isPresent() {
        return present;
    }

    public String getHeureRendu() {
        return heureRendu;
    }
}
