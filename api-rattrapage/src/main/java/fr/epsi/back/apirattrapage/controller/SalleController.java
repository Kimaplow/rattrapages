package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Salle;
import fr.epsi.back.apirattrapage.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/salles")
public class SalleController {

    @Autowired
    private SalleRepository salleRepository;

    @GetMapping("")
    public List<Salle> getAllSalles(){
        return salleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Salle getSalle(@PathVariable long id){
        return salleRepository.findById(id).get();
    }

    @PostMapping("")
    public Salle createSalle(@RequestBody Salle salle){
        return salleRepository.save(salle);
    }

    @PutMapping("/{id}")
    public Salle updateSalle(@PathVariable long id, @RequestBody Salle salle){
        Salle s = salleRepository.findById(id).get();

        if(salle.getNom() != null){
            s.setNom(salle.getNom());
        }

        if(salle.getNbrPlace() != 0){
            s.setNbrPlace(salle.getNbrPlace());
        }

        return salleRepository.save(s);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable long id){
        Salle salle = salleRepository.findById(id).get();
        salleRepository.delete(salle);
    }

}
