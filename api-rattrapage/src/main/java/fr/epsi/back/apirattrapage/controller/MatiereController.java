package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Matiere;
import fr.epsi.back.apirattrapage.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/matieres")
public class MatiereController {

    @Autowired
    private MatiereRepository matiereRepository;

    @GetMapping("")
    public List<Matiere> getAllMatiere(){
        return matiereRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Matiere> getMatiere(@PathVariable long id){
        return matiereRepository.findById(id);
    }

}
