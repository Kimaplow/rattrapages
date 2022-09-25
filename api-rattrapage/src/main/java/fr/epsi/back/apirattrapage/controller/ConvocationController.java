package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.entity.ConvocationKey;
import fr.epsi.back.apirattrapage.entity.Eleve;
import fr.epsi.back.apirattrapage.repository.ConvocationRepository;
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

    @GetMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}")
    public Convocation getConvocation(@PathVariable long idRattrapage, @PathVariable long idEleve){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        return convocationRepository.findById(key).get();
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

    @PostMapping("")
    public Convocation createConvocation(@RequestBody Convocation convocation){
        return convocationRepository.save(convocation);
    }

    @PutMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}")
    public Convocation updateConvocation(@PathVariable long idRattrapage, @PathVariable long idEleve, @RequestBody Convocation convocation){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        Convocation c =  convocationRepository.findById(key).orElseThrow();

        if(convocation.getNote() == 0 && c.isPresent()){
            c.setNote(1);
        }
        else if(convocation.getNote() != 0){
            c.setNote(convocation.getNote());
        }

        //todo verif autre champs

        /*
        if(convocation.getEleve() != null){
            c.setEleve(convocation.getEleve());
        }

        if(convocation.getRattrapage() != null){
            c.setRattrapage(convocation.getRattrapage());
        }
        */

        return convocationRepository.save(c);
    }

    @PatchMapping("/rattrapage/{idRattrapage}/eleve/{idEleve}/present")
    public Convocation setPresentEleve(@PathVariable long idRattrapage, @PathVariable long idEleve){
        ConvocationKey key = new ConvocationKey(idRattrapage, idEleve);
        Convocation c =  convocationRepository.findById(key).orElseThrow();
        c.setPresent(!c.isPresent());
        return convocationRepository.save(c);
    }

}