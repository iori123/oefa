package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.Vocal;

import java.util.List;
import java.util.Optional;

public interface VocalRepository {
    List<Vocal> getAll();
    Optional<Vocal> getVocal(Integer id);
    Vocal save( Vocal vocal);
    void delete( Integer id);
}
