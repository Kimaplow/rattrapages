package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnesRepository extends JpaRepository<Personne, Long> {

    List<Personne> findByRole(String role);

    Personne findByMail(String mail);

}
