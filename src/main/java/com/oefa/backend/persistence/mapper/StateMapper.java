package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.Condition;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.persistence.entity.Especialidad;
import com.oefa.backend.persistence.entity.Estado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateMapper {
    @Mappings({
            @Mapping(source = "codigoEstado", target = "id"),
            @Mapping(source = "nombreEstado", target = "name"),
            @Mapping(source = "tipoEstado", target = "type"),
            @Mapping(source = "fechaCreacion", target = "dateCreated"),

    })
    Condition toCondition(Estado estado);
    List<Condition> toConditions(List<Estado> estados);
    @InheritInverseConfiguration
    @Mapping(target = "expedientes", ignore = true)
    Estado toEstado (Condition condition);
}
