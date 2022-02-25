package com.oefa.backend.domain;

public class Document {
    private Integer id;
    private String ticketAuth;
    private String ticketSession;
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
