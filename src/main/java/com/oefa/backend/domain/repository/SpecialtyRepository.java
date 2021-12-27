package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.Specialty;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepository {
    List<Specialty> getAll();
    Optional<Specialty> getSpecialty(Integer id);
    Specialty save( Specialty specialty);
    void delete( Integer id);
}
