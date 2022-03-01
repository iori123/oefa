package com.oefa.backend.domain.service;
import com.oefa.backend.domain.Proceding;
import com.oefa.backend.domain.repository.ProcedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedingService {
    @Autowired
    private ProcedingRepository procedingRepository;

    public List<Proceding> getAll() {
        return procedingRepository.getAll();
    }
    public Optional<Proceding> getProcedingByNumberProceding (String numberProceding) {
        return procedingRepository.getProcedingByNumberProceding(numberProceding);
    }
    public Optional<Proceding> getProceding(Integer id) {
        return procedingRepository.getProceding(id);
    }
    public Proceding save( Proceding proceding) {
        return procedingRepository.save(proceding);
    }
    public boolean delete( Integer id) {
        return getProceding(id).map( proceding -> {
            procedingRepository.delete(id);
            return true ;
        }).orElse(false);
    }
}
