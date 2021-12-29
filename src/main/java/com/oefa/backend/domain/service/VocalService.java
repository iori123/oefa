package com.oefa.backend.domain.service;

import com.oefa.backend.domain.Vocal;
import com.oefa.backend.domain.repository.VocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VocalService {
    @Autowired
    private VocalRepository vocalRepository;

    public List<Vocal> getAll() {
        return vocalRepository.getAll();
    }
    public Optional<Vocal> getVocal(Integer id) {
        return vocalRepository.getVocal(id);
    }

    public Vocal save( Vocal vocal) {
        return vocalRepository.save(vocal);
    }
    public boolean delete( Integer id) {
        return getVocal(id).map( specialty -> {
            vocalRepository.delete(id);
            return true ;
        }).orElse(false);
    }
}
