package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.service.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SalariesController {

    @Autowired
    private SalariesService salariesService;

    @GetMapping("/salaries")
    public Iterable<Salaries> getArticles() {
        return salariesService.getSalaries();
    }

    @GetMapping("/salarie/{id}")
    public Optional<Salaries> getArticle(@PathVariable Long id) {
        return salariesService.getSalarie(id);
    }

    @DeleteMapping("/salarie/{id}")
    public void deleteArticle(@PathVariable Long id) {
        salariesService.deleteSalarie(id);
    }

    @PutMapping("/salarie")
    public Salaries updateArticle(@RequestBody Salaries salaries)  {
        return salariesService.updateSalarie(salaries);
    }

    @PostMapping("/salarie")
    public Salaries saveArticle(@RequestBody Salaries salaries)  {
        return salariesService.saveSalarie(salaries);
    }
}
