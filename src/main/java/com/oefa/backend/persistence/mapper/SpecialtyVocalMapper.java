package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.SpecialtyVocal;
import com.oefa.backend.persistence.entity.VocalEspecialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring", uses = {SpecialtyMapper.class})
public interface SpecialtyVocalMapper {
    @Mappings({
            @Mapping(source = "codigoVocalEspecialidad.codigoEspecialidad", target = "specialtyId"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated")
    })
    SpecialtyVocal toSpecialtyVocal(VocalEspecialidad especialidad);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoVocalEspecialidad.codigoVocal", ignore = true),
            @Mapping(target = "vocalPonente", ignore = true),
            @Mapping(target = "especialidad", ignore = true)
    })
    VocalEspecialidad toVocalEspecialidad(SpecialtyVocal specialtyVocal);
}
