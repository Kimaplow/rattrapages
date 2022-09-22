package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "rattrapage")
public class Rattrapage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rattrapage")
    private long idRattrapage;
    private String sujet;
    private java.util.Date date;
    private java.util.Date heure;
    private java.util.Date duree;
    private String etat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_matiere")
    @JsonIgnoreProperties({"rattrapages"})
    private Matiere matiere;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_salle")
    @JsonIgnoreProperties({"rattrapages"})
    private Salle salle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_professeur")
    @JsonIgnoreProperties({"rattrapagesSurveillant", "rattrapagesProfesseur"})
    private Personne professeur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_surveillant")
    @JsonIgnoreProperties({"rattrapagesSurveillant", "rattrapagesProfesseur"})
    private Personne surveillant;

    @OneToMany(mappedBy = "rattrapage")
    List<Convocation> convocations;

    public long getIdRattrapage() {
        return idRattrapage;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.util.Date getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public java.util.Date getDuree() {
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

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Personne getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Personne professeur) {
        this.professeur = professeur;
    }

    public Personne getSurveillant() {
        return surveillant;
    }

    public void setSurveillant(Personne surveillant) {
        this.surveillant = surveillant;
    }

}
