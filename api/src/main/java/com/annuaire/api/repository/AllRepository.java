package com.annuaire.api.repository;

import com.annuaire.api.controller.ServicesController;
import com.annuaire.api.controller.SitesController;
import com.annuaire.api.controller.model.All;
import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.controller.model.Services;
import com.annuaire.api.controller.model.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AllRepository {

    @Autowired
    private SitesController sitesController;

    @Autowired
    private ServicesController servicesController;
    public List<All> getAll(Iterable<Salaries> salaries, Long service, Long site) {
        List<All> listAll = new ArrayList<All>();
        for (Salaries salarie : salaries) {
            Optional<Sites> respSite = sitesController.getSite(salarie.getFkSite());
            Optional<Services> respService = servicesController.getService(salarie.getFkService());
            if (service == null && site == null || service == null && site == respSite.get().getId() || service == respService.get().getId() && site == null || site == respSite.get().getId() && service == respService.get().getId()) {
                All resp = new All();
                resp.setId(salarie.getId());
                resp.setMail(salarie.getEmail());
                resp.setNom(salarie.getNom());
                resp.setPrenom(salarie.getPrenom());
                resp.setTelephoneFixe(salarie.getTelephoneFixe());
                resp.setTelephonePortable(salarie.getTelephonePortable());
                resp.setVille(respSite.get().getVille());
                resp.setAttribution(respSite.get().getAttribution());
                resp.setService(respService.get().getNom());
                resp.setIdService(respService.get().getId());
                resp.setIdSite(respSite.get().getId());
                listAll.add(resp);
            }
        }
        return listAll;
    }

}
