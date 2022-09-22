package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "convocation")
public class Convocation {

    @EmbeddedId
    ConvocationKey id;

    @ManyToOne
    @MapsId("idEleve")
    @JoinColumn(name="id_eleve")
    private Eleve eleve;

    @ManyToOne
    @MapsId("idRattrapage")
    @JoinColumn(name="id_rattrapage")
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private Rattrapage rattrapage;

    private float note;

    public ConvocationKey getId() {
        return id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Rattrapage getRattrapage() {
        return rattrapage;
    }

    public void setRattrapage(Rattrapage rattrapage) {
        this.rattrapage = rattrapage;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
