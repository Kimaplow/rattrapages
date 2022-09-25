package fr.epsi.back.apirattrapage.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder(toBuilder = true)
public class ConvocationKey implements Serializable {

    @Column(name="id_eleve")
    private long idEleve;

    @Column(name="id_rattrapage")
    private long idRattrapage;

    public ConvocationKey(){};

    public ConvocationKey(long idRattrapage, long idEleve){
        this.idEleve = idEleve;
        this.idRattrapage = idRattrapage;
    }

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
