package com.oefa.backend.domain.service;

import com.oefa.backend.domain.Document;
import com.oefa.backend.domain.Specialty;
import com.oefa.backend.domain.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;
    public Optional<Document> getDocumentByTickets(String tAuth,String tSession) {return documentRepository.getDocumentByTicketAuthAndTicketSession(tAuth,tSession);}

}
