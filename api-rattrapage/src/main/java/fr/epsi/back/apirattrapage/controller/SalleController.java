package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Salle;
import fr.epsi.back.apirattrapage.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/salles")
public class SalleController {

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("")
    public List<Salle> getAllSalles(){
        return salleRepository.findAll();
    }
}
