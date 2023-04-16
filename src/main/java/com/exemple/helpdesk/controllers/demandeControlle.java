package com.exemple.helpdesk.controllers;

import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.payload.request.LoginRequest;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.service.DemandeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class demandeControlle {
    @Autowired
    private DemandeRepository demanderepositor;

    @Autowired
    private DemandeService demandeService;



    @Secured(value={"ROLE_USER"})
    @RequestMapping( value="/demande",method= RequestMethod.GET)
    public Collection<Demande> getContacts(){

        return demanderepositor.findAll();
    }
   /* @RequestMapping( value="/demanders/{id_demande}",method= RequestMethod.GET)
    public Long demandes(Long id_demande){

        return demanderepositor/.findAlla(id_demande);
    }
    @RequestMapping( value="/demander",method= RequestMethod.GET)
    public List<User> getContactss(Long id_demande){

        return demanderepositor.find_ide(id_demande);

    }*/


    /*@PreAuthorize("hasRole('ROLE_ADMIN')")*/
    @RequestMapping(value ="/addDemande",method=RequestMethod.POST)
    public Demande addDemande(@RequestBody DemandePojo model, Authentication authentication) {

        return demandeService.addDemande(model,authentication);



    }
    @RequestMapping( value="/demandes/{id}",method= RequestMethod.GET)
    public List<Demande> find_id_employer(@PathVariable Long id){

        return demanderepositor.find_id_employer(id);
    }


    @RequestMapping( value="/chercher",method= RequestMethod.GET)
    public Page<Demande> chercherDemande(@RequestParam(name = "mc",defaultValue = "") String mc,
                                         @RequestParam(name = "page",defaultValue = "0")     int page,
                                         @RequestParam(name = "size",defaultValue = "5") int size){

        return demanderepositor.chercher("%"+mc+"%",new PageRequest(page,size));
    }


    @RequestMapping(value = "/demane/{id_demande}",method =RequestMethod.GET )
    public Optional<Demande> getProductsByNa(@PathVariable Long id_demande) {


        return  demanderepositor.findById(id_demande);

    }

    @RequestMapping(value="/contacts/{id_demande}",method=RequestMethod.PATCH)
    public Demande save(@PathVariable Long id_demande, @RequestBody Demande c){
        Optional<Demande> d =demanderepositor.findById(id_demande);
        d.get().setStatus("confirmed");
        Demande de=demanderepositor.save(d.get());

        return de;
    }
    @RequestMapping(value="/changestatus/{id_demande}",method=RequestMethod.PATCH)
    public Demande changeStatus(@PathVariable Long id_demande, @RequestBody Demande c){
        Optional<Demande> d =demanderepositor.findById(id_demande);
        d.get().setStatus("Canceled");
        Demande de=demanderepositor.save(d.get());

        return de;
    }

    @RequestMapping(value="/contactss/{id_demande}",method=RequestMethod.PUT)
    public Demande saves(@PathVariable Long id_demande, @RequestBody Demande c){
        c.setId_demande(id_demande);
        return demanderepositor.save(c);
    }


    @RequestMapping(value="/Deletedemande/{id_demande}",method=RequestMethod.DELETE)
    public boolean supprimer(@PathVariable Long id_demande){
        this.demandeService.deleteBy(id_demande);
        return true;
    }
















}
