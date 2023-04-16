package com.exemple.helpdesk.service.impl;

import com.exemple.helpdesk.Pojo.DemandePojo;
import com.exemple.helpdesk.models.Demande;
import com.exemple.helpdesk.models.Materiel;
import com.exemple.helpdesk.models.User;
import com.exemple.helpdesk.repository.DemandeRepository;
import com.exemple.helpdesk.repository.UserRepository;
import com.exemple.helpdesk.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeRepository demandeRepository;
    @Override
    public Demande addDemande(DemandePojo model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()).get();
        Demande demande = new Demande();
        demande.setDate(model.getDate());
        demande.setStatus("En cours");
        demande.setAllocation_motive(model.getAllocation_motive());
        demande.setUser(user);
        Materiel materiel=new Materiel();
        materiel.setEquipement(model.getEquipement());
        materiel.setModel(model.getModel());
        materiel.setSerial(model.getSerial());
        materiel.setComment(model.getComment());
        demande.setMateriel( materiel);
        /* Materiel materiel= new Materiel();
        demande.setMateriel((Set<Materiel>) materiel);*/

        return  demandeRepository.save(demande);
    }
    @Override
    public void deleteBy(Long id_demande) {
        demandeRepository.deleteById(id_demande);

    }
}
