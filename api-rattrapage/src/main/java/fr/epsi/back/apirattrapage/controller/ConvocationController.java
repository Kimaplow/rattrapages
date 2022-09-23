package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.entity.ConvocationKey;
import fr.epsi.back.apirattrapage.entity.Eleve;
import fr.epsi.back.apirattrapage.entity.Rattrapage;
import fr.epsi.back.apirattrapage.repository.ConvocationRepository;
import fr.epsi.back.apirattrapage.repository.EleveRepository;
import fr.epsi.back.apirattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/convocations")
public class ConvocationController {

    @Autowired
    private ConvocationRepository convocationRepository;

    @GetMapping("")
    public List<Convocation> getAllConvocations(){
        return convocationRepository.findAll();
    }

    @GetMapping("/rattrapage/{id}/eleves")
    public List<Eleve> getEleveByIdRattrapage(@PathVariable long id){
        List<Convocation> convocations = convocationRepository.findAll();
        List<Eleve> eleves = new ArrayList<>();
        for (Convocation c: convocations) {
            if(c.getId().getIdRattrapage() == id){
                eleves.add(c.getEleve());
            }
        }
        return eleves;
    }

    @PatchMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}")
    public void setPresentEleve(@PathVariable long idRattrapage, @PathVariable long idEleve){
        List<Convocation> convocations = convocationRepository.findAll();
        for (Convocation c: convocations) {
            if(c.getId().getIdRattrapage() == idRattrapage && c.getId().getIdEleve() == idEleve){
                c.setPresent(!c.isPresent());
                convocationRepository.save(c);
            }
        }
    }

}