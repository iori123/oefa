package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "T_MAP_VOCAL_PONENTE")
public class VocalPonente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_VOCAL")
    private String codigoVocal;

    @Column(name = "CODIGO_ESTADO")
    private String codigoEstado;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "USUARIO_ACTUALIZA_AUDITORIA")
    private String usuarioActualiza;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZA_AUDITORIA")
    private LocalDateTime fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESTADO", insertable = false,updatable = false)
    private Estado estado;

    @OneToMany(mappedBy = "vocalPonente")
    private List<VocalEspecialidad> especialidades;
}
