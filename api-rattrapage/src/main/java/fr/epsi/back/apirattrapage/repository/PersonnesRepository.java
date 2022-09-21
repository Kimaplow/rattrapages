package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnesRepository extends JpaRepository<Personne, Long> {
}
