package com.oefa.backend.domain.repository;

import com.oefa.backend.domain.Document;

import java.util.Optional;

public interface DocumentRepository {
    Optional<Document> getDocumentByTicketAuthAndTicketSession(String tAuth, String tSession);

}
