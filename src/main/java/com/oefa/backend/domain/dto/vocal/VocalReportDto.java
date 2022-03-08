package com.oefa.backend.domain.dto.vocal;

public class VocalReportDto {
    private Integer idVocal;
    private String vocal ;
    private Integer assignProcedigns;
    private Integer inactiveProcedings;
    private Integer resolveProcedings;

    public Integer getIdVocal() {
        return idVocal;
    }

    public void setIdVocal(Integer idVocal) {
        this.idVocal = idVocal;
    }

    public String getVocal() {
        return vocal;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }

    public Integer getAssignProcedigns() {
        return assignProcedigns;
    }

    public void setAssignProcedigns(Integer assignProcedigns) {
        this.assignProcedigns = assignProcedigns;
    }

    public Integer getInactiveProcedings() {
        return inactiveProcedings;
    }

    public void setInactiveProcedings(Integer inactiveProcedings) {
        this.inactiveProcedings = inactiveProcedings;
    }

    public Integer getResolveProcedings() {
        return resolveProcedings;
    }

    public void setResolveProcedings(Integer resolveProcedings) {
        this.resolveProcedings = resolveProcedings;
    }
}
