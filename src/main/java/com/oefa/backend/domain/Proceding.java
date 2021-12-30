package com.oefa.backend.domain;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class Proceding {
    private Integer id;
    private String numberProceding;
    private String ruc;
    private String socialReason;
    private String direction;
    private String memorandum;
    private String description;
    private LocalDateTime dateReception;
    private LocalDateTime dateAttention;
    private String userCreated;
    private String userUpdated;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdated;

    private Integer conditionId;
    private Integer officeFromId;
    private Integer economicSectorId;

    private Condition condition;
    private OfficeFrom officeFrom;
    private EconomicSector economicSector;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberProceding() {
        return numberProceding;
    }

    public void setNumberProceding(String numberProceding) {
        this.numberProceding = numberProceding;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(String memorandum) {
        this.memorandum = memorandum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDateTime dateReception) {
        this.dateReception = dateReception;
    }

    public LocalDateTime getDateAttention() {
        return dateAttention;
    }

    public void setDateAttention(LocalDateTime dateAttention) {
        this.dateAttention = dateAttention;
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

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public Integer getOfficeFromId() {
        return officeFromId;
    }

    public void setOfficeFromId(Integer officeFromId) {
        this.officeFromId = officeFromId;
    }

    public Integer getEconomicSectorId() {
        return economicSectorId;
    }

    public void setEconomicSectorId(Integer economicSectorId) {
        this.economicSectorId = economicSectorId;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public OfficeFrom getOfficeFrom() {
        return officeFrom;
    }

    public void setOfficeFrom(OfficeFrom officeFrom) {
        this.officeFrom = officeFrom;
    }

    public EconomicSector getEconomicSector() {
        return economicSector;
    }

    public void setEconomicSector(EconomicSector economicSector) {
        this.economicSector = economicSector;
    }
}
