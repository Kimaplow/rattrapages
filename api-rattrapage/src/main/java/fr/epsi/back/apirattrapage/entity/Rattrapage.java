package fr.epsi.back.apirattrapage.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rattrapage")
public class Rattrapage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rattrapage")
    private long idRattrapage;
    private String sujet;
    private Date date;
    private Time heure;
    private Time duree;
    private String etat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_matiere", nullable = false)
    private Matiere matiere;

    public long getIdRattrapage() {
        return idRattrapage;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
