package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Rattrapage;
import fr.epsi.back.apirattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/rattrapages")
public class RattrapageController {

    @Autowired
    private RattrapageRepository rattrapageRepository;

    @GetMapping("")
    public List<Rattrapage> getAllRattrapages(){
        return rattrapageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rattrapage> getRattrapage(@PathVariable long id){
        return rattrapageRepository.findById(id);
    }

    @PostMapping("")
    public Rattrapage createRattrapage(@RequestBody Rattrapage rattrapage){
        return rattrapageRepository.save(rattrapage);
    }

    @GetMapping("/surveillant/{id}")
    public List<Rattrapage> getRattrapageBySurveillant(@PathVariable long id){
        List<Rattrapage> rattrapages = rattrapageRepository.findAll();
        List<Rattrapage> rattrapageSurveillant = new ArrayList<>();
        for (Rattrapage rattrapage : rattrapages) {
            if(rattrapage.getSurveillant().getId() == id){
                rattrapageSurveillant.add(rattrapage);
            }
        }
        return rattrapageSurveillant;
    }

}
