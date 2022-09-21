package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Rattrapage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RattrapageRepository extends JpaRepository<Rattrapage, Long> {
}
