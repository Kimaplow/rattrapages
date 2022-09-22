package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSalle;
    private String nom;
    private int nbrPlace;

    @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private List<Rattrapage> rattrapages;

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

    public List<Rattrapage> getRattrapages() {
        return rattrapages;
    }

    public void setRattrapages(List<Rattrapage> rattrapages) {
        this.rattrapages = rattrapages;
    }
}
