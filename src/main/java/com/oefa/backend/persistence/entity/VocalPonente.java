package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "T_MAP_VOCAL_PONENTE")
@SequenceGenerator(name="N", sequenceName="vocal_sec", allocationSize=1)

public class VocalPonente {
    @Id
    @GeneratedValue(generator="N")
    @Column(name = "CODIGO_VOCAL")
    private Integer codigoVocal;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "USUARIO_ACTUALIZA_AUDITORIA")
    private String usuarioActualiza;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZA_AUDITORIA")
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "vocalPonente" ,cascade = {CascadeType.ALL})
    private List<VocalEspecialidad> especialidades;

    @OneToMany(mappedBy = "vocal" ,cascade = {CascadeType.ALL})
    private List<ExpedienteVocal> expedientes;

    public List<ExpedienteVocal> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<ExpedienteVocal> expedientes) {
        this.expedientes = expedientes;
    }

    public Integer getCodigoVocal() {
        return codigoVocal;
    }

    public void setCodigoVocal(Integer codigoVocal) {
        this.codigoVocal = codigoVocal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<VocalEspecialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<VocalEspecialidad> especialidades) {
        this.especialidades = especialidades;
    }

}
