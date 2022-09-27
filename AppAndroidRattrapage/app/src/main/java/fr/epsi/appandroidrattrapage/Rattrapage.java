package fr.epsi.appandroidrattrapage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import fr.epsi.appandroidrattrapage.entity.Matiere;
import fr.epsi.appandroidrattrapage.entity.Personne;
import fr.epsi.appandroidrattrapage.entity.Salle;

public class Rattrapage implements Serializable {

    @SerializedName("matiere")
    private Matiere matiere;

    @SerializedName("professeur")
    private Personne personne;

    @SerializedName("salle")
    private Salle salle;

    public Matiere getMatiere() {
        return matiere;
    }

    public Personne getProfesseur() {
        return personne;
    }

    public Salle getSalle() {
        return salle;
    }

}
