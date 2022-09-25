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
    public Eleve getEleve(@PathVariable long id){
        return eleveRepository.findById(id).get();
    }

    @PostMapping("")
    public Eleve createEleve(@RequestBody Eleve eleve){
        return eleveRepository.save(eleve);
    }

    @PutMapping("/{id}")
    public Eleve updateEleve(@PathVariable long id, @RequestBody Eleve eleve){
        Eleve e = eleveRepository.findById(id).get();

        if(eleve.getPrenom() != null){
            e.setPrenom(eleve.getPrenom());
        }

        if(eleve.getNom() != null){
            e.setNom(eleve.getNom());
        }

        if(eleve.getPhoto() != null){
            e.setPhoto(eleve.getPhoto());
        }

        return eleveRepository.save(e);
    }

    @DeleteMapping("{id}")
    public void deleteEleve(@PathVariable long id){
        Eleve e = eleveRepository.findById(id).get();
        eleveRepository.delete(e);
    }

}
