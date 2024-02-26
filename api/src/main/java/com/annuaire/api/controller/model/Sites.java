package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sites")
public class Sites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ville;

    public Long getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public String getAttribution() {
        return attribution;
    }

    private String attribution;
}
