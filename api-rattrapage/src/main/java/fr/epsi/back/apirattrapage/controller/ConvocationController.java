package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.entity.ConvocationKey;
import fr.epsi.back.apirattrapage.entity.Eleve;
import fr.epsi.back.apirattrapage.repository.ConvocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

}
