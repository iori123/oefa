package com.oefa.backend.domain.service;

import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll() {
        return specialtyRepository.getAll();
    }
    public Optional<Specialty> getSpecialty( Integer id) {
        return specialtyRepository.getSpecialty(id);
    }
    public Specialty save( Specialty specialty) {
        return specialtyRepository.save(specialty);
    }
    public boolean delete( Integer id) {
        return getSpecialty(id).map( specialty -> {
            specialtyRepository.delete(id);
            return true ;
        }).orElse(false);
    }
}
