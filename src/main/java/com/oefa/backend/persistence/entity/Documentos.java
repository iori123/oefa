package com.oefa.backend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Table(name = "T_MVD_ATENCION_DOCUMENTOS")
public class Documentos {
    @Id
    @Column(name = "ID_ATENCION_DOCUMENTOS")
    private Integer id;

    @Column(name = "TX_TICKET_AUHT")
    private String ticketAuth;

    @Column(name = "TX_TICKET_SESSION")
    private String ticketSession;

    @Column(name = "TX_UUID")
    private String uuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketAuth() {
        return ticketAuth;
    }

    public void setTicketAuth(String ticketAuth) {
        this.ticketAuth = ticketAuth;
    }

    public String getTicketSession() {
        return ticketSession;
    }

    public void setTicketSession(String ticketSession) {
        this.ticketSession = ticketSession;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
