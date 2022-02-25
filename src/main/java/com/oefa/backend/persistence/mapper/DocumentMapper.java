package com.oefa.backend.persistence.mapper;

import com.oefa.backend.domain.Document;
import com.oefa.backend.persistence.entity.Documentos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "ticketAuth", target = "ticketAuth"),
            @Mapping(source = "ticketSession", target = "ticketSession"),
            @Mapping(source = "uuid", target = "uuid"),


    })
    Document toDocument(Documentos documentos);
    @InheritInverseConfiguration
    Documentos toDocumento (Document document);
}
