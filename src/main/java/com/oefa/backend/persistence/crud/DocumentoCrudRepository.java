package com.oefa.backend.persistence.crud;

import com.oefa.backend.persistence.entity.Documentos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocumentoCrudRepository extends CrudRepository<Documentos,Integer> {
    @Query(value = "SELECT * FROM DOCUMENTS WHERE XXXX = ?1",
            countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
            nativeQuery = true)
    Optional<Documentos> findByTicketAuthAndTicketSession(String ticketAuth, String ticketSession);

}
