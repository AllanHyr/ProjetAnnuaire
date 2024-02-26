package com.annuaire.api.service;

import com.annuaire.api.controller.SalariesController;
import com.annuaire.api.controller.model.All;
import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.repository.AllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllService {

    @Autowired
    private AllRepository allRepository;
    @Autowired
    private SalariesController salariesController;
    public List<All> getAll(String nom, Long service, Long site) {
        Iterable<Salaries> salaries = salariesController.getSalarieNom(nom);
        return allRepository.getAll(salaries, service, site);
    }
}
