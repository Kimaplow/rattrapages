package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Personne;
import fr.epsi.back.apirattrapage.entity.Rattrapage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RattrapageRepository extends JpaRepository<Rattrapage, Long> {

    List<Rattrapage> findBySurveillant(Personne surveillant);

    List<Rattrapage> findByProfesseur(Personne professeur);

    List<Rattrapage> findByEtat(String etat);

    List<Rattrapage> findByEtatAndSurveillant(String etat, Personne surveillant);
    List<Rattrapage> findByEtatAndProfesseur(String etat, Personne professeur);

}
