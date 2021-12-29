package com.oefa.backend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VocalEspecialidadPK implements Serializable {
    @Column(name = "CODIGO_VOCAL")
    private Integer codigoVocal;

    @Column(name = "CODIGO_ESPECIALIDAD")
    private Integer codigoEspecialidad;

    public Integer getCodigoVocal() {
        return codigoVocal;
    }

    public void setCodigoVocal(Integer codigoVocal) {
        this.codigoVocal = codigoVocal;
    }

    public Integer getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(Integer codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }
}
