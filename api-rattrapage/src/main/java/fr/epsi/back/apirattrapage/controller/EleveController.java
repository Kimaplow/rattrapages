package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Eleve;
import fr.epsi.back.apirattrapage.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/eleves")
public class EleveController {

    @Autowired
    private EleveRepository eleveRepository;

    @GetMapping("")
    public List<Eleve> getAllEleves(){
        return eleveRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Eleve> getEleve(@PathVariable long id){
        return eleveRepository.findById(id);
    }

    @PostMapping("")
    public Eleve createEleve(@RequestBody Eleve eleve){
        return eleveRepository.save(eleve);
    }

}
