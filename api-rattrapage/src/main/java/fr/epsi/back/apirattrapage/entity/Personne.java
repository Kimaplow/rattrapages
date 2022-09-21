package fr.epsi.back.apirattrapage.entity;

import javax.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersonne;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "id_rattrapage")
    private Rattrapage rattrapage;

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
}
