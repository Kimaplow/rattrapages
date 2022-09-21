package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatiere;
    private String code;
    private String libelle;

    @OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("matiere")
    private List<Rattrapage> rattrapages;

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

    public List<Rattrapage> getRattrapages() {
        return rattrapages;
    }

    public void setRattrapages(List<Rattrapage> rattrapages) {
        this.rattrapages = rattrapages;
    }
}
