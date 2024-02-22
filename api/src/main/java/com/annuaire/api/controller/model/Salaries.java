package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "salaries")
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    @Column(name="telephone_fixe")
    private String telephoneFixe;

    @Column(name="telephone_portable")
    private String telephonePortable;

    private String email;

    @Column(name="fk_service")
    private Long fkService;

    @Column(name="fk_site")
    private Long fkSite;
}
