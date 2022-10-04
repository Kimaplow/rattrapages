package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Personne;
import fr.epsi.back.apirattrapage.entity.Rattrapage;
import fr.epsi.back.apirattrapage.repository.PersonnesRepository;
import fr.epsi.back.apirattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/rattrapages")
public class RattrapageController {

    @Autowired
    private RattrapageRepository rattrapageRepository;

    @Autowired
    private PersonnesRepository personnesRepository;

    @GetMapping("")
    public List<Rattrapage> getAllRattrapages(){
        return rattrapageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rattrapage getRattrapage(@PathVariable long id){
        return rattrapageRepository.findById(id).get();
    }

    @GetMapping("/noneffectues")
    public List<Rattrapage> getRattrapageNonEffectues(){
        return rattrapageRepository.findByEtat("Non effectué");
    }

    @PostMapping("")
    public Rattrapage createRattrapage(@RequestBody Rattrapage rattrapage){
        rattrapage.setEtat("Non effectué");
        return rattrapageRepository.save(rattrapage);
    }

    @GetMapping("/surveillant/{id}")
    public List<Rattrapage> getRattrapegeBySurveillant(@PathVariable long id){
        Personne surveillant = personnesRepository.findById(id).get();
        return rattrapageRepository.findBySurveillant(surveillant);
    }

    @GetMapping("/professeur/{id}")
    public List<Rattrapage> getRattrapegeByProfesseur(@PathVariable long id){
        Personne professeur = personnesRepository.findById(id).get();
        return rattrapageRepository.findByProfesseur(professeur);
    }

    @GetMapping("/surveillant/{id}/restant")
    public List<Rattrapage> getRattrapageNonEffectuesBySurveillant(@PathVariable long id){
        Personne surveillant = personnesRepository.findById(id).get();
        return rattrapageRepository.findByEtatAndSurveillant("Non effectué", surveillant);
    }

    @GetMapping("/professeur/{id}/restant")
    public List<Rattrapage> getRattrapageNonEffectuesByProfesseur(@PathVariable long id){
        Personne professeur = personnesRepository.findById(id).get();
        return rattrapageRepository.findByEtatAndProfesseur("Non effectué", professeur);
    }

    @PutMapping("/{id}")
    public Rattrapage updateRattrapage(@PathVariable long id, @RequestBody Rattrapage rattrapage){
        Rattrapage r = rattrapageRepository.findById(id).get();

        if(rattrapage.getSujet() != null){
            r.setSujet(rattrapage.getSujet());
        }

        if(rattrapage.getSurveillant() != null){
            r.setSurveillant(rattrapage.getSurveillant());
        }

        if(rattrapage.getProfesseur() != null){
            r.setProfesseur(rattrapage.getProfesseur());
        }

        if(rattrapage.getSalle() != null){
            r.setSalle(rattrapage.getSalle());
        }

        if(rattrapage.getMatiere() != null){
            r.setMatiere(rattrapage.getMatiere());
        }

        return rattrapageRepository.save(r);
    }

    @PatchMapping("/{id}/etat")
    public Rattrapage patchEtatRattrapage(@PathVariable long id, @RequestBody Rattrapage rattrapage){
        Rattrapage r = rattrapageRepository.findById(id).get();
        r.setEtat(rattrapage.getEtat());
        return rattrapageRepository.save(r);
    }

    @DeleteMapping("/{id}")
    public void deleteRattrapage(@PathVariable long id){
        Rattrapage r = rattrapageRepository.findById(id).get();
        rattrapageRepository.delete(r);
    }

}
