package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Especialidad;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EspecialidadCrudRepository extends CrudRepository<Especialidad,Integer> {
    Optional<Especialidad> findBynombreEspecialidad(String nombreEspecialidad);
}
