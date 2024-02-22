package com.annuaire.api.repository;

import com.annuaire.api.controller.model.Sites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitesRepository extends CrudRepository<Sites, Long> {
}
