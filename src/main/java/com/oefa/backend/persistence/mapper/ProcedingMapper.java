package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.EconomicSector;
import com.oefa.backend.domain.Proceding;
import com.oefa.backend.persistence.entity.Expediente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {OfficeFromMapper.class, EconomicSectorMapper.class ,StateMapper.class , VocalMapper.class})
public interface ProcedingMapper {
    @Mappings({
            @Mapping(source = "codigoExpediente", target = "id"),
            @Mapping(source = "numeroExpediente", target = "numberProceding"),
            @Mapping(source = "ruc", target = "ruc"),
            @Mapping(source = "razonSocial", target = "socialReason"),
            @Mapping(source = "domicilio", target = "direction"),
            @Mapping(source = "administrado", target = "administrate"),
            @Mapping(source = "hojaTramite", target = "roadMap"),
            @Mapping(source = "documentoElevacion", target = "docElevation"),
            @Mapping(source = "memorandum", target = "memorandum"),

            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "fechaAtencion", target = "dateAttention"),
            @Mapping(source = "fechaRecepcion", target = "dateReception"),
            @Mapping(source = "codigoEstado", target = "conditionId"),
            @Mapping(source = "codigoOficina", target = "officeFromId"),
            @Mapping(source = "codigoSector", target = "economicSectorId"),
            @Mapping(source = "codigoVocal", target = "vocalId"),


            @Mapping(source = "estado", target = "condition"),
            @Mapping(source = "oficinaProveniente", target = "officeFrom"),
            @Mapping(source = "sectorEconomico", target = "economicSector"),
            @Mapping(source = "vocal", target = "vocal"),

            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaCreacion", target = "dateCreation"),
            @Mapping(source = "fechaActualizacion", target = "dateUpdated")



    })
    Proceding toProceding(Expediente expediente);
    List<Proceding> toProcedings(List<Expediente> expedientes);

    @InheritInverseConfiguration
    Expediente toExpediente ( Proceding proceding);
}
