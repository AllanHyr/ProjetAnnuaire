package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Sites;
import com.annuaire.api.service.SitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SitesController {

    @Autowired
    private SitesService sitesService;

    @GetMapping("/sites")
    public Iterable<Sites> getSites() {
        return sitesService.getSites();
    }

    @GetMapping("/site/{id}")
    public Optional<Sites> getSite(@PathVariable Long id) {
        return sitesService.getSite(id);
    }

    @DeleteMapping("/site/{id}")
    public void deleteSite(@PathVariable Long id) {
        sitesService.deleteSite(id);
    }

    @PutMapping("/site")
    public Sites updateSite(@RequestBody Sites sites)  {
        return sitesService.updateSite(sites);
    }

    @PostMapping("/site")
    public Sites saveSite(@RequestBody Sites sites)  {
        return sitesService.saveSite(sites);
    }

}
