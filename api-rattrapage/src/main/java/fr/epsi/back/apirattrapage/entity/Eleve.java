package fr.epsi.back.apirattrapage.entity;

import javax.persistence.*;

@Entity
@Table(name = "eleve")
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEleve;
    private String nom;
    private String prenom;
    private String photo;

    public long getIdEleve() {
        return idEleve;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}
