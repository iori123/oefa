package com.oefa.backend.domain.dto.proceding;

import com.oefa.backend.domain.Proceding;

import java.util.List;

public class ProcedingsAssignResponseDTO {
    private Integer quantity;
    private String  description;
    private List<Proceding> unassignedProcedings;
    private List<Proceding> assignedProcedings;

    public ProcedingsAssignResponseDTO(Integer quantity, String description, List<Proceding> unassignedProcedings, List<Proceding> assignedProcedings) {
        this.quantity = quantity;
        this.description = description;
        this.unassignedProcedings = unassignedProcedings;
        this.assignedProcedings = assignedProcedings;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Proceding> getUnassignedProcedings() {
        return unassignedProcedings;
    }

    public void setUnassignedProcedings(List<Proceding> unassignedProcedings) {
        this.unassignedProcedings = unassignedProcedings;
    }

    public List<Proceding> getAssignedProcedings() {
        return assignedProcedings;
    }

    public void setAssignedProcedings(List<Proceding> assignedProcedings) {
        this.assignedProcedings = assignedProcedings;
    }
}
