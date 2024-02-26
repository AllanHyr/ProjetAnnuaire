package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "salaries")
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    String prenom;

    @Column(name="telephone_fixe")
    String telephoneFixe;

    @Column(name="telephone_portable")
    String telephonePortable;

    String email;

    @Column(name="fk_service")
    Long fkService;

    @Column(name="fk_site")
    Long fkSite;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    public String getTelephonePortable() {
        return telephonePortable;
    }

    public String getEmail() {
        return email;
    }

    public Long getFkService() {
        return fkService;
    }

    public Long getFkSite() {
        return fkSite;
    }
}
