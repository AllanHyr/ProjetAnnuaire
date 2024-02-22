package com.annuaire.api.service;


import com.annuaire.api.controller.model.Services;
import com.annuaire.api.repository.ServicesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    public Optional<Services> getService(final Long id) {
        return servicesRepository.findById(id);
    }

    public Iterable<Services> getServices() {
        return servicesRepository.findAll();
    }

    public void deleteService(final Long id) {
        servicesRepository.deleteById(id);
    }

    public Services updateService(Services services) {
        Services savedServices = servicesRepository.save(services);
        return savedServices;
    }
    public Services saveService(Services services) {
        Services savedServices = servicesRepository.save(services);
        return savedServices;
    }
}
