package com.annuaire.api.service;

import com.annuaire.api.controller.model.Salaries;
import com.annuaire.api.repository.SalariesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;

    public Optional<Salaries> getSalarie(final Long id) {
        return salariesRepository.findById(id);
    }

    public Iterable<Salaries> getSalaries() {
        return salariesRepository.findAll();
    }

    public void deleteSalarie(final Long id) {
        salariesRepository.deleteById(id);
    }

    public Salaries updateSalarie(Salaries salaries) {
        Salaries savedSalaries = salariesRepository.save(salaries);
        return savedSalaries;
    }
    public Salaries saveSalarie(Salaries salaries) {
        Salaries savedSalaries = salariesRepository.save(salaries);
        return savedSalaries;
    }
}
