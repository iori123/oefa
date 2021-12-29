package com.oefa.backend.persistence;

import com.oefa.backend.domain.EconomicSector;

import com.oefa.backend.domain.repository.EconomicSectorRepository;
import com.oefa.backend.persistence.crud.SectorEconomicoCrudRepository;
import com.oefa.backend.persistence.entity.Especialidad;
import com.oefa.backend.persistence.entity.SectorEconomico;
import com.oefa.backend.persistence.mapper.EconomicSectorMapper;
import com.oefa.backend.persistence.mapper.SpecialtyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class SectorEconomicoRepository implements EconomicSectorRepository {
    @Autowired
    private SectorEconomicoCrudRepository sectorEconomicoCrudRepository;
    @Autowired
    private EconomicSectorMapper mapper;
    @Override
    public List<EconomicSector> getAll() {
        List<SectorEconomico> sectoresEconomicos = (List<SectorEconomico>) sectorEconomicoCrudRepository.findAll();
        return mapper.toEconomicSectors(sectoresEconomicos);
    }
    @Override
    public Optional<EconomicSector> getEconomicSectorByName(String name) {
        return sectorEconomicoCrudRepository.findBynombreSector(name).map(sectorEconomico -> mapper.toEconomicSector(sectorEconomico));
    }
    @Override
    public Optional<EconomicSector> getEconomicSector(Integer id) {
        return sectorEconomicoCrudRepository.findById(id).map(sectorEconomico -> mapper.toEconomicSector(sectorEconomico));
    }

    @Override
    public EconomicSector save(EconomicSector economicSector) {
        SectorEconomico sectorEconomico = mapper.toSectorEconomico(economicSector);
        return mapper.toEconomicSector(sectorEconomicoCrudRepository.save(sectorEconomico));
    }
    @Override
    public void delete( Integer idSectorEconomico) {
        sectorEconomicoCrudRepository.deleteById(idSectorEconomico);
    }
}
