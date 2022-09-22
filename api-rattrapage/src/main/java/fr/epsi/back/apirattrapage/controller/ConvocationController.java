package fr.epsi.back.apirattrapage.controller;

import fr.epsi.back.apirattrapage.entity.Convocation;
import fr.epsi.back.apirattrapage.repository.ConvocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
