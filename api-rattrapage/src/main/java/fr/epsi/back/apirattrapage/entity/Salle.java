package fr.epsi.back.apirattrapage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSalle;
    private String nom;
    private int nbrPlace;

    public long getIdSalle() {
        return idSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }
}
