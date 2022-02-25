package com.oefa.backend.persistence;

import com.oefa.backend.domain.Document;
import com.oefa.backend.domain.repository.DocumentRepository;
import com.oefa.backend.persistence.crud.DocumentoCrudRepository;
import com.oefa.backend.persistence.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class DocumentoRepository implements DocumentRepository {
    @Autowired
    DocumentoCrudRepository documentoCrudRepository;
    @Autowired
    DocumentMapper mapper;

    @Override
    public Optional<Document> getDocumentByTicketAuthAndTicketSession(String tAuth, String tSession) {
        return documentoCrudRepository.findByTicketAuthAndTicketSession(tAuth,tSession).map(documentos -> mapper.toDocument(documentos));
    }
}
