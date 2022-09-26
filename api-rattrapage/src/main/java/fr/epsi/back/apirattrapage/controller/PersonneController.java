package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Personne;
import fr.epsi.back.apirattrapage.repository.PersonnesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
    public Personne getPersonne(@PathVariable long id){
        return personnesRepository.findById(id).get();
    }

    @GetMapping("/role/{role}")
    public List<Personne> getPersonneByRole(@PathVariable String role){
        return personnesRepository.findByRole(role);
    }

    @PostMapping("")
    public Personne createPersonne(@RequestBody Personne personne){
        return personnesRepository.save(personne);
    }

    @PostMapping("/login")
    public Personne login(@RequestBody Personne personne){
        Personne p = personnesRepository.findByMail(personne.getMail());
        if(p != null){
            if(Objects.equals(personne.getPassword(), p.getPassword())){
                return p;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public Personne updatePersonne(@PathVariable long id, @RequestBody Personne personne){
        Personne p = personnesRepository.findById(id).get();

        if(personne.getMail() != null){
            p.setMail(personne.getMail());
        }

        if(personne.getNom() != null){
            p.setNom(personne.getNom());
        }

        if(personne.getPrenom() != null){
            p.setPrenom(personne.getPrenom());
        }

        if(personne.getPassword() != null){
            p.setPassword(personne.getPassword());
        }

        return personnesRepository.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable long id){
        Personne p = personnesRepository.findById(id).get();
        personnesRepository.delete(p);
    }

}
