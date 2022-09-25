package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne")
    private long idPersonne;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String role;

    @OneToMany(mappedBy = "professeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private List<Rattrapage> rattrapagesProfesseur;

    @OneToMany(mappedBy = "surveillant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private List<Rattrapage> rattrapagesSurveillant;

    public long getId() {
        return idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Rattrapage> getRattrapagesProfesseur() {
        return rattrapagesProfesseur;
    }

    public void setRattrapagesProfesseur(List<Rattrapage> rattrapagesProfesseur) {
        this.rattrapagesProfesseur = rattrapagesProfesseur;
    }

    public List<Rattrapage> getRattrapagesSurveillant() {
        return rattrapagesSurveillant;
    }

    public void setRattrapagesSurveillant(List<Rattrapage> rattrapagesSurveillant) {
        this.rattrapagesSurveillant = rattrapagesSurveillant;
    }
}
