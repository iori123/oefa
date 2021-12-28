package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "T_MAP_SECTOR_ECONOMICO")
public class SectorEconomico {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="economic_sec")
    @SequenceGenerator(name="economic_sec", sequenceName="economic_sec", allocationSize=0)
    @Column(name = "CODIGO_SECTOR")
    private Integer codigoSector;

    @Column(name = "NOMBRE_SECTOR")
    private String nombreSector;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "USUARIO_ACTUALIZA_AUDITORIA")
    private String usuarioActualiza;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZA_AUDITORIA")
    private LocalDateTime fechaActualizacion;

    public Integer getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
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

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
