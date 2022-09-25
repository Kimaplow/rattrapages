package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Matiere;
import fr.epsi.back.apirattrapage.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Matiere getMatiere(@PathVariable long id){
        return matiereRepository.findById(id).get();
    }

    @PostMapping("")
    public Matiere createMetiere(@RequestBody Matiere matiere){
        return matiereRepository.save(matiere);
    }

    @PutMapping("/{id}")
    public Matiere updateMatiere(@PathVariable long id, @RequestBody Matiere matiere){
        Matiere m = matiereRepository.findById(id).get();

        if(matiere.getCode() != null){
            m.setCode(matiere.getCode());
        }

        if(matiere.getLibelle() != null){
            m.setLibelle(matiere.getLibelle());
        }

        return matiereRepository.save(m);
    }

    @DeleteMapping("{id}")
    public void deleteMatiere(@PathVariable long id){
        Matiere m = matiereRepository.findById(id).get();
        matiereRepository.delete(m);
    }

}
