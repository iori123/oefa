package com.oefa.backend.domain.service;

import com.oefa.backend.domain.EconomicSector;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.repository.EconomicSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EconomicSectorService {
    @Autowired
    private EconomicSectorRepository economicSectorRepository;

    public List<EconomicSector> getAll() {
        return economicSectorRepository.getAll();
    }
    public Optional<EconomicSector> getEconomicSector(Integer id) {
        return economicSectorRepository.getEconomicSector(id);
    }
    public EconomicSector save( EconomicSector economicSector) {
        return economicSectorRepository.save(economicSector);
    }
    public boolean delete( Integer id) {
        return getEconomicSector(id).map( economicSector -> {
            economicSectorRepository.delete(id);
            return true ;
        }).orElse(false);
    }
}
