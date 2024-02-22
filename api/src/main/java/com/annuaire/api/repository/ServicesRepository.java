package com.annuaire.api.repository;

import com.annuaire.api.controller.model.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends CrudRepository<Services, Long> {
}
