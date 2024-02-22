package com.annuaire.api.controller.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sites")
public class Sites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ville;

    private String attribution;
}
