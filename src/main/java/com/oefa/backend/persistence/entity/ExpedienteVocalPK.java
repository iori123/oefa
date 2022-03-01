package com.oefa.backend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExpedienteVocalPK implements Serializable {
    @Column(name = "CODIGO_EXPEDIENTE")
    private Integer codigoExpediente;

    @Column(name = "CODIGO_VOCAL")
    private Integer codigoVocal;

    public Integer getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCodigoExpediente(Integer codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public Integer getCodigoVocal() {
        return codigoVocal;
    }

    public void setCodigoVocal(Integer codigoVocal) {
        this.codigoVocal = codigoVocal;
    }
}
