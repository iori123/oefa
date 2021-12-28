package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.EconomicSector;

import java.util.List;
import java.util.Optional;

public interface EconomicSectorRepository {
    List<EconomicSector> getAll();
    Optional<EconomicSector> getEconomicSector(Integer id);
    Optional<EconomicSector> getEconomicSectorByName(String name);
    EconomicSector save( EconomicSector economicSector);
    void delete( Integer id);
}
