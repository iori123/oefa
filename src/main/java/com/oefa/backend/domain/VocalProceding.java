package com.oefa.backend.domain;

import java.time.LocalDateTime;

public class VocalProceding {
    private Integer vocalId;
    private String userCreated;
    private LocalDateTime dateCreated;
    private String userUpdated;
    private LocalDateTime dateUpdated;

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

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
