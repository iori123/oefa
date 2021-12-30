package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Expediente;
import org.springframework.data.repository.CrudRepository;

public interface ExpedienteCrudRepository extends CrudRepository<Expediente,Integer> {
}
