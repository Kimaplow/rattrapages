package fr.epsi.back.apirattrapage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatiere;
    private String code;
    private String libelle;

    public long getIdMatiere() {
        return idMatiere;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
