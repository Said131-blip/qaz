package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.repository.materielrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class materielControlle {
    @Autowired
    private materielrepository materielrepositor;

    @RequestMapping(value="/materiel",method= RequestMethod.GET)
    public List<Materiel> getContacts(){

        return materielrepositor.findAll();
    }
    @RequestMapping(value ="/postmateril",method=RequestMethod.POST)
    public Materiel addCompte(@RequestBody Materiel compte) {
        return materielrepositor.save(compte);
    }

    @RequestMapping(value = "/materiel/{id_materiel}",method =RequestMethod.GET )
    public Optional<Materiel> getProductsByNa(@PathVariable Long id_materiel) {


        return  materielrepositor.findById(id_materiel);

    }
}
