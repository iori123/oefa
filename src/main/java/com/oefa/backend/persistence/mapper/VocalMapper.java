package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.Vocal;
import com.oefa.backend.persistence.entity.VocalPonente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {SpecialtyVocalMapper.class})
public interface VocalMapper {
    @Mappings({
            @Mapping(source = "codigoVocal", target = "id"),
            @Mapping(source = "nombres", target = "names"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated"),
            @Mapping(source = "fechaActualizacion", target = "dateUpdated"),
            @Mapping(source = "especialidades", target = "specialties")
    })
    Vocal toVocal(VocalPonente vocalPonente);
    List<Vocal> toVocals(List<VocalPonente> vocalesPonentes);

    @InheritInverseConfiguration

    @Mappings({
            @Mapping(target = "nombreCompleto", ignore = true),
    })
    VocalPonente toVocalPonente ( Vocal vocal);
}
