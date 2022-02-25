package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Documentos;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocumentoCrudRepository extends CrudRepository<Documentos,Integer> {
    Optional<Documentos> findByTicketAuthAndTicketSession(String ticketAuth, String ticketSession);

}
