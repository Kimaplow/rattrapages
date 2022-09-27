package fr.epsi.appandroidrattrapage.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Convocation implements Serializable {

    @SerializedName("present")
    private boolean present;

    public boolean isPresent() {
        return present;
    }
}
