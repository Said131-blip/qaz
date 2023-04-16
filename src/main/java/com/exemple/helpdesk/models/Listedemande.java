package com.exemple.helpdesk.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class Listedemande {

    private Long id;


    private String username;

    private String prenom;

    private String departement;

    private String email;
    private Long id_demande;
    private Date date;
    private String Allocation_motive ;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId_demande() {
        return id_demande;
    }

    public void setId_demande(Long id_demande) {
        this.id_demande = id_demande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAllocation_motive() {
        return Allocation_motive;
    }

    public void setAllocation_motive(String allocation_motive) {
        Allocation_motive = allocation_motive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Listedemande(Long id, String username, String prenom, String departement, String email, Long id_demande, Date date, String allocation_motive, String status) {
        this.id = id;
        this.username = username;
        this.prenom = prenom;
        this.departement = departement;
        this.email = email;
        this.id_demande = id_demande;
        this.date = date;
        Allocation_motive = allocation_motive;
        this.status = status;
    }
}
