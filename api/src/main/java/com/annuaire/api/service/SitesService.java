package com.annuaire.api.service;


import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.controller.model.Sites;
import com.annuaire.api.repository.SitesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SitesService {

    @Autowired
    private SitesRepository sitesRepository;

    public Optional<Sites> getSite(final Long id) {
        return sitesRepository.findById(id);
    }

    public Iterable<Sites> getSites() {
        return sitesRepository.findAll();
    }

    public void deleteSite(final Long id) {
        sitesRepository.deleteById(id);
    }

    public Sites updateSite(Sites sites) {
        Sites savedSites = sitesRepository.save(sites);
        return savedSites;
    }
    public Sites saveSite(Sites sites) {
        Sites savedSites = sitesRepository.save(sites);
        return savedSites;
    }
}
