package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
