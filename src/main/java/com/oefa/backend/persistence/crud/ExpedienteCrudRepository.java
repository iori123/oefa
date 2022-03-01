package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Expediente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExpedienteCrudRepository extends CrudRepository<Expediente,Integer> {
    Optional<Expediente> findByNumeroExpedienteContainingIgnoreCase(String numeroExpediente);
}
