package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_GEP_VOCAL_PONENTE_ESPECIALID")
public class VocalEspecialidad {
    @EmbeddedId
    private VocalEspecialidadPK codigoVocalEspecialidad;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @MapsId("codigoVocal")
    @JoinColumn(name = "CODIGO_VOCAL", insertable = false, updatable = false)
    private VocalPonente vocalPonente;

    @ManyToOne
    //@MapsId("codigoEspecialidad")
    @JoinColumn(name = "CODIGO_ESPECIALIDAD", insertable = false, updatable = false)
    private Especialidad especialidad;


    public VocalEspecialidadPK getCodigoVocalEspecialidad() {
        return codigoVocalEspecialidad;
    }

    public void setCodigoVocalEspecialidad(VocalEspecialidadPK codigoVocalEspecialidad) {
        this.codigoVocalEspecialidad = codigoVocalEspecialidad;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public VocalPonente getVocalPonente() {
        return vocalPonente;
    }

    public void setVocalPonente(VocalPonente vocalPonente) {
        this.vocalPonente = vocalPonente;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
