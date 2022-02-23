package com.oefa.backend.domain;

import java.time.LocalDateTime;

public class VocalSpecialty {
    private Integer vocalId;
    private String userCreated;
    private LocalDateTime dateCreated;

    public Integer getVocalId() {
        return vocalId;
    }

    public void setVocalId(Integer vocalId) {
        this.vocalId = vocalId;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
