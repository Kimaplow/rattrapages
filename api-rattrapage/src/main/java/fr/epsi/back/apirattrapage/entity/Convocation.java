package fr.epsi.back.apirattrapage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "convocation")
public class Convocation {

    @EmbeddedId
    ConvocationKey id;

    @ManyToOne
    @MapsId("idEleve")
    @JoinColumn(name="id_eleve", insertable=false, updatable=false)
    private Eleve eleve;

    @ManyToOne
    @MapsId("idRattrapage")
    @JoinColumn(name="id_rattrapage", insertable=false, updatable=false)
    @JsonIgnoreProperties({"matiere", "salle", "professeur", "surveillant"})
    private Rattrapage rattrapage;

    private float note;
    private boolean present;

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

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

}
