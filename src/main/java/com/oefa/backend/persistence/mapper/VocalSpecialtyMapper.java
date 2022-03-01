package com.oefa.backend.persistence.mapper;
import com.oefa.backend.domain.VocalSpecialty;
import com.oefa.backend.persistence.entity.VocalEspecialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring", uses = {VocalMapper.class})

public interface VocalSpecialtyMapper {
    @Mappings({
            @Mapping(source = "codigoVocalEspecialidad.codigoVocal", target = "vocalId"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated")
    })
    VocalSpecialty toVocalSpecialty(VocalEspecialidad vocal);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoVocalEspecialidad.codigoEspecialidad", ignore = true),
            @Mapping(target = "vocalPonente", ignore = true),
            @Mapping(target = "especialidad", ignore = true)
    })
    VocalEspecialidad toVocalEspecialidad(VocalSpecialty vocalSpecialty);
}
