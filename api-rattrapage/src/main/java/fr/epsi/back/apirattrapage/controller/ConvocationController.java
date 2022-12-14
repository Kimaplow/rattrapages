package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.entity.ConvocationKey;
import fr.epsi.back.apirattrapage.entity.Eleve;
import fr.epsi.back.apirattrapage.entity.Rattrapage;
import fr.epsi.back.apirattrapage.repository.ConvocationRepository;
import fr.epsi.back.apirattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/convocations")
public class ConvocationController {

    @Autowired
    private ConvocationRepository convocationRepository;

    @Autowired
    private RattrapageRepository rattrapageRepository;

    @GetMapping("")
    public List<Convocation> getAllConvocations(){
        return convocationRepository.findAll();
    }

    @GetMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}")
    public Convocation getConvocation(@PathVariable long idRattrapage, @PathVariable long idEleve){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        return convocationRepository.findById(key).get();
    }

    @GetMapping("/rattrapage/{id}/eleves")
    public List<Convocation> getConvocationByIdRattrapage(@PathVariable long id){
        Rattrapage r = rattrapageRepository.findById(id).get();
        return convocationRepository.findByRattrapage(r);
    }

    @GetMapping("/rattrapage/{id}/eleves/present")
    public List<Eleve> getElevePresentByIdRattrapage(@PathVariable long id){
        Rattrapage r = rattrapageRepository.findById(id).get();
        List<Convocation> convocationList = convocationRepository.findByRattrapage(r);
        List<Eleve> eleves = new ArrayList<>();
        for (Convocation c: convocationList) {
            if(c.isPresent()){
                eleves.add(c.getEleve());
            }
        }
        return eleves;
    }

    @PostMapping("")
    public Convocation createConvocation(@RequestBody Convocation convocation){
        convocation.setNote(0);
        convocation.setPresent(false);
        return convocationRepository.save(convocation);
    }

    @PatchMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}/present")
    public Convocation setPresentEleve(@PathVariable long idRattrapage, @PathVariable long idEleve){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        Convocation c =  convocationRepository.findById(key).get();
        if(c.isPresent()){
            c.setPresent(false);
            c.setHeureRendu(null);
        }
        else{
            c.setPresent(true);
            c.setHeureRendu(Time.valueOf(java.time.LocalTime.now()));
        }
        return convocationRepository.save(c);
    }

    @PatchMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}/note")
    public Convocation setNote(@PathVariable long idRattrapage, @PathVariable long idEleve,
                               @RequestBody Convocation convocation){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        Convocation c =  convocationRepository.findById(key).get();
        c.setNote(convocation.getNote());
        return convocationRepository.save(c);
    }

    @DeleteMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}")
    public void deleteConvocation(@PathVariable long idRattrapage, @PathVariable long idEleve){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        Convocation c =  convocationRepository.findById(key).get();
        convocationRepository.delete(c);
    }

}