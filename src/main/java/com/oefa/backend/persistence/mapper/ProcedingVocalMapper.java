package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.ProcedingVocal;
import com.oefa.backend.persistence.entity.ExpedienteVocal;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring", uses = {ProcedingMapper.class})

public interface ProcedingVocalMapper {
    @Mappings({
            @Mapping(source = "codigoExpedienteVocal.codigoExpediente", target = "procedingId"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaActualiza", target = "dateUpdated")
    })
    ProcedingVocal toProcedingVocal(ExpedienteVocal expedienteVocal);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoExpedienteVocal.codigoVocal", ignore = true),
            @Mapping(target = "vocal", ignore = true),
            @Mapping(target = "expediente", ignore = true)
    })
    ExpedienteVocal toExpedienteVocal(ProcedingVocal procedingVocal);
}
