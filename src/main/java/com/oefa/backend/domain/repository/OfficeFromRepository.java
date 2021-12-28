package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.OfficeFrom;
import com.oefa.backend.domain.Specialty;

import java.util.List;
import java.util.Optional;

public interface OfficeFromRepository {
    List<OfficeFrom> getAll();
    Optional<OfficeFrom> getOfficeFrom(Integer id);
    Optional<OfficeFrom> getOfficeFromByName(String name);

    OfficeFrom save( OfficeFrom officeFrom);
    void delete( Integer id);
}
