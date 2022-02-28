package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.Specialty;
import com.oefa.backend.persistence.entity.Especialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",  uses = {VocalSpecialtyMapper.class})
public interface SpecialtyMapper {
    @Mappings({
            @Mapping(source = "codigoEspecialidad", target = "id"),
            @Mapping(source = "nombreEspecialidad", target = "name"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated"),
            @Mapping(source = "fechaActualizacion", target = "dateUpdated"),
             @Mapping(source = "vocales", target = "vocals")

    })
    Specialty toSpecialty(Especialidad especialidad);
    List<Specialty> toSpecialtys(List<Especialidad> especialidades);
    @InheritInverseConfiguration
    //@Mapping(target = "vocales", ignore = true)

    Especialidad toEspecialidad ( Specialty specialty);
}
