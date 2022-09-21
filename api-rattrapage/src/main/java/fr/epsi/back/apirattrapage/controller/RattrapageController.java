package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Rattrapage;
import fr.epsi.back.apirattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/rattrapages")
public class RattrapageController {

    @Autowired
    private RattrapageRepository rattrapageRepository;

    @GetMapping("")
    public List<Rattrapage> getAllRattrapages(){
        return rattrapageRepository.findAll();
    }

}
