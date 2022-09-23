package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Personne;
import fr.epsi.back.apirattrapage.repository.PersonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/personnes")
public class PersonneController {

    @Autowired
    private PersonnesRepository personnesRepository;

    @GetMapping("")
    public List<Personne> getAllPersonnes(){
        return personnesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Personne> getPersonne(@PathVariable long id){
        return personnesRepository.findById(id);
    }

    @PostMapping("")
    public Personne createPersonne(@RequestBody Personne personne){
        return personnesRepository.save(personne);
    }

}
