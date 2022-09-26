package fr.epsi.back.apirattrapage.repository;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.entity.ConvocationKey;
import fr.epsi.back.apirattrapage.entity.Rattrapage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvocationRepository extends JpaRepository<Convocation, ConvocationKey> {

    List<Convocation> findByRattrapage(Rattrapage rattrapage);

}
