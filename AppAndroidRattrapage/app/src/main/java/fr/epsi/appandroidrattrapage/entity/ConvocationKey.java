package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConvocationKey implements Serializable {

    @SerializedName("idRattrapage")
    private long idRattrapage;

    @SerializedName("idEleve")
    private long idEleve;

    public long getIdRattrapage() {
        return idRattrapage;
    }

    public long getIdEleve() {
        return idEleve;
    }
}
