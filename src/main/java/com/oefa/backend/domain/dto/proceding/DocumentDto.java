package com.oefa.backend.domain.dto.proceding;

public class DocumentDto {
    private String ticketAuth;
    private String tickerSession;

    public String getTicketAuth() {
        return ticketAuth;
    }

    public void setTicketAuth(String ticketAuth) {
        this.ticketAuth = ticketAuth;
    }

    public String getTickerSession() {
        return tickerSession;
    }

    public void setTickerSession(String tickerSession) {
        this.tickerSession = tickerSession;
    }
}
