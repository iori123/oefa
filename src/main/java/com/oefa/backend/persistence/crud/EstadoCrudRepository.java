package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoCrudRepository extends CrudRepository<Estado,String> {
}
