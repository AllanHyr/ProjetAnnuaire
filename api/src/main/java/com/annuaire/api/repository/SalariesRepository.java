package com.annuaire.api.repository;

import com.annuaire.api.controller.model.Salaries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalariesRepository extends CrudRepository<Salaries, Long> {

    Iterable<Salaries> findByNomContaining(String nom);

}
