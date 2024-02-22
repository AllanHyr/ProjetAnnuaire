package com.annuaire.api.controller;

import com.annuaire.api.controller.model.Services;
import com.annuaire.api.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/services")
    public Iterable<Services> getServices() {
        return servicesService.getServices();
    }

    @GetMapping("/service/{id}")
    public Optional<Services> getService(@PathVariable Long id) {
        return servicesService.getService(id);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }

    @PutMapping("/service")
    public Services updateService(@RequestBody Services services)  {
        return servicesService.updateService(services);
    }

    @PostMapping("/service")
    public Services saveService(@RequestBody Services services)  {
        return servicesService.saveService(services);
    }
}
