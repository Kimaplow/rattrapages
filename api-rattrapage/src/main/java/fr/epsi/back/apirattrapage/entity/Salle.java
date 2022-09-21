package fr.epsi.back.apirattrapage.entity;

import javax.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSalle;
    private String nom;
    private int nbrPlace;

    @ManyToOne
    @JoinColumn(name = "rattrapage_id")
    private Rattrapage rattrapage;

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

    public Rattrapage getRattrapage() {
        return rattrapage;
    }

    public void setRattrapage(Rattrapage rattrapage) {
        this.rattrapage = rattrapage;
    }
}
