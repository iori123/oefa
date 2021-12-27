package com.oefa.backend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VocalEspecialidadPK implements Serializable {
    @Column(name = "CODIGO_VOCAL")
    private String codigoVocal;

    @Column(name = "CODIGO_ESPECIALIDAD")
    private String codigoEspecialidad;

    public String getCodigoVocal() {
        return codigoVocal;
    }

    public void setCodigoVocal(String codigoVocal) {
        this.codigoVocal = codigoVocal;
    }

    public String getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(String codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }
}
