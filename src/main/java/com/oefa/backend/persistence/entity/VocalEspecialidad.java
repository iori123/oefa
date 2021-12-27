package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_GEP_VOCAL_PONENTE_ESPECIALIDAD")
public class VocalEspecialidad {
    @EmbeddedId
    private VocalEspecialidadPK codigoVocalEspecialidad;

    @Column(name = "USUARIO_CREA_AUTIDORIA")
    private LocalDateTime usuarioCrea;

    @Column(name = "FECHA_CREA_AUTIDORIA")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "CODIGO_VOCAL", insertable = false, updatable = false)
    private VocalPonente vocalPonente;

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESPECIALIDAD", insertable = false, updatable = false)
    private Especialidad especialidad;
}
