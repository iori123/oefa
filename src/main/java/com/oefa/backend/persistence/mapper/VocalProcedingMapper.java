package com.oefa.backend.persistence.mapper;
import com.oefa.backend.domain.VocalProceding;
import com.oefa.backend.persistence.entity.ExpedienteVocal;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper( componentModel = "spring", uses = {VocalMapper.class})
public interface VocalProcedingMapper {
        @Mappings({
                @Mapping(source = "codigoExpedienteVocal.codigoVocal", target = "vocalId"),
                @Mapping(source = "usuarioCrea", target = "userCreated"),
                @Mapping(source = "fechaCreacion", target = "dateCreated"),
                @Mapping(source = "usuarioActualiza", target = "userUpdated"),
                @Mapping(source = "fechaActualiza", target = "dateUpdated")
        })
        VocalProceding toVocalProceding(ExpedienteVocal vocal);
        @InheritInverseConfiguration
        @Mappings({
                @Mapping(target = "codigoVocalEspecialidad.codigoEspecialidad", ignore = true),
                @Mapping(target = "vocal", ignore = true),
                @Mapping(target = "expediente", ignore = true)
        })
        ExpedienteVocal toVocalExpediente(VocalProceding vocalProceding );

}
