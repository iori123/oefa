package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "T_GEP_USUARIO_EXPEDIENTE")
public class ExpedienteVocal {
    @EmbeddedId
    private ExpedienteVocalPK codigoExpedienteVocal;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "USUARIO_ACTUALIZA_AUDITORIA")
    private String usuarioActualiza;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZA_AUDITORIA")
    private LocalDateTime fechaActualiza;

    @ManyToOne
    @MapsId("codigoExpediente")
    @JoinColumn(name = "CODIGO_EXPEDIENTE", insertable = false, updatable = false)
    private Expediente expediente;

    @ManyToOne
    //@MapsId("codigoVocal")
    @JoinColumn(name = "CODIGO_VOCAL", insertable = false, updatable = false)
    private VocalPonente vocal;

    public ExpedienteVocalPK getCodigoExpedienteVocal() {
        return codigoExpedienteVocal;
    }

    public void setCodigoExpedienteVocal(ExpedienteVocalPK codigoExpedienteVocal) {
        this.codigoExpedienteVocal = codigoExpedienteVocal;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(LocalDateTime fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public VocalPonente getVocal() {
        return vocal;
    }

    public void setVocal(VocalPonente vocal) {
        this.vocal = vocal;
    }
}
