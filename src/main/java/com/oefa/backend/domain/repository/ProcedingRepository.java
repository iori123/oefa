package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.Specialty;

import java.util.List;
import java.util.Optional;

public interface ProcedingRepository {
    List<Proceding> getAll();
    Optional<Proceding> getProceding(Integer id);
    Proceding save( Proceding proceding);
    void delete( Integer id);
}
