package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
