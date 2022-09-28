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

    public ConvocationKey getKey() {
        return key;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public boolean isPresent() {
        return present;
    }

}
