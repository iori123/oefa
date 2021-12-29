package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.VocalPonente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VocalPonenteCrudRepository extends CrudRepository<VocalPonente,Integer> {
    List<VocalPonente> findByNombreCompletoContainingIgnoreCase(String nombreCompleto);

}
