package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.EconomicSector;
import com.oefa.backend.persistence.entity.SectorEconomico;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EconomicSectorMapper {
    @Mappings({
            @Mapping(source = "codigoSector", target = "id"),
            @Mapping(source = "nombreSector", target = "name"),
            @Mapping(source = "usuarioCrea", target = "userCreated"),
            @Mapping(source = "usuarioActualiza", target = "userUpdated"),
            @Mapping(source = "fechaCreacion", target = "dateCreation"),
            @Mapping(source = "fechaActualizacion", target = "dateUpdated")



    })
    EconomicSector toEconomicSector(SectorEconomico sectorEconomico);
    List<EconomicSector> toEconomicSectors(List<SectorEconomico> sectoresEconomicos);

    @InheritInverseConfiguration
    SectorEconomico toSectorEconomico ( EconomicSector economicSector);
}
