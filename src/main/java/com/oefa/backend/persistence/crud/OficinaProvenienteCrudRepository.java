package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.OficinaProveniente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OficinaProvenienteCrudRepository extends CrudRepository<OficinaProveniente,Integer> {
    Optional<OficinaProveniente> findBynombreOficina(String nombreOficina);
}
