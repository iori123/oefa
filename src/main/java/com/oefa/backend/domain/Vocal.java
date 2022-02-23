package com.oefa.backend.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Vocal {
    private Integer id;
    private String names;
    private String lastName;
    private String email;
    private String state;
    private String userCreated;
    private String userUpdated;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    private List<SpecialtyVocal> specialties;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(String userUpdated) {
        this.userUpdated = userUpdated;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<SpecialtyVocal> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<SpecialtyVocal> specialties) {
        this.specialties = specialties;
    }
}
