package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.OficinaProveniente;
import com.oefa.backend.persistence.entity.SectorEconomico;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SectorEconomicoCrudRepository extends CrudRepository<SectorEconomico,Integer> {
    Optional<SectorEconomico> findBynombreSector(String nombreSector);

}
