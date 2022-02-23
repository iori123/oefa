package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.Vocal;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

public interface ProcedingRepository {
    List<Proceding> getAll();
    List<Proceding> getAllByVocalId(Integer id);
    Optional<Proceding> getProcedingByNumberProceding(String numberProceding);

    Optional<Proceding> getProceding(Integer id);
    Proceding save( Proceding proceding);
    void delete( Integer id);
}
