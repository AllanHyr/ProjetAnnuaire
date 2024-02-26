package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.service.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:9300/")
public class SalariesController {

    @Autowired
    private SalariesService salariesService;

    @GetMapping("/salaries")
    public Iterable<Salaries> getSalaries() {
        return salariesService.getSalaries();
    }

    @GetMapping("/salarie/{id}")
    public Optional<Salaries> getSalarie(@PathVariable Long id) {
        return salariesService.getSalarie(id);
    }

    @GetMapping("/salaries/{nom}")
    public Iterable<Salaries> getSalarieNom(@RequestParam(required = false) String nom) {
        if (nom != null && !nom.isEmpty()) {
            return salariesService.getSalarieNom(nom);
        } else {
            return salariesService.getSalaries();
        }

    }

    @DeleteMapping("/salarie/{id}")
    public void deleteSalarie(@PathVariable Long id) {
        salariesService.deleteSalarie(id);
    }

    @PutMapping("/salarie")
    public Salaries updateSalarie(@RequestBody Salaries salaries)  {
        return salariesService.updateSalarie(salaries);
    }

    @PostMapping("/salarie")
    public Salaries saveSalarie(@RequestBody Salaries salaries)  {
        return salariesService.saveSalarie(salaries);
    }
}
