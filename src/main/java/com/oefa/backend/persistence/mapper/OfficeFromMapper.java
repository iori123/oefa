package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.OfficeFrom;
import com.oefa.backend.persistence.entity.OficinaProveniente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfficeFromMapper {
    @Mappings({
            @Mapping(source = "codigoOficina", target = "id"),
            @Mapping(source = "nombreOficina", target = "name"),
            @Mapping(source = "direccionOficina", target = "direction"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaCreacion", target = "dateCreated"),
            @Mapping(source = "fechaActualizacion", target = "dateUpdated")



    })
    OfficeFrom toOfficeFrom(OficinaProveniente oficinaProveniente);
    List<OfficeFrom> toOfficesFrom(List<OficinaProveniente> oficinasProvenientes);
    @InheritInverseConfiguration
    OficinaProveniente toOficinaProveniente ( OfficeFrom officeFrom);
}
