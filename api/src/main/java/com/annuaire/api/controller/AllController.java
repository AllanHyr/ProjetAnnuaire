package com.annuaire.api.controller;

import com.annuaire.api.controller.model.All;
import com.annuaire.api.service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:9300/")
public class AllController {

    @Autowired
    private AllService allService;

    @GetMapping("/all")
    public List<All> getAll(@RequestParam(required = false) String nom, @RequestParam(required = false) Long service, @RequestParam(required = false) Long site) {
        return allService.getAll(nom, service, site);
    }
}
