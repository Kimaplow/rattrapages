package fr.epsi.back.apirattrapage.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConvocationKey implements Serializable {

    @Column(name="id_eleve")
    private long idEleve;

    @Column(name="id_rattrapage")
    private long idRattrapage;

    public long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(long idEleve) {
        this.idEleve = idEleve;
    }

    public long getIdRattrapage() {
        return idRattrapage;
    }

    public void setIdRattrapage(long idRattrapage) {
        this.idRattrapage = idRattrapage;
    }
}
