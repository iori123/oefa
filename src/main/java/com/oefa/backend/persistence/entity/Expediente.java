package com.oefa.backend.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "T_MVP_EXPEDIENTE")
@SequenceGenerator(name="E", sequenceName="expediente_sec", allocationSize=1)
public class Expediente {
    @Id
    @Column(name = "CODIGO_EXPEDIENTE")
    @GeneratedValue(generator="E")
    private Integer codigoExpediente;

    @Column(name = "NUMERO_EXPEDIENTE")
    private String numeroExpediente;

    @Column(name = "RUC_ADMINISTRADO")
    private String ruc;

    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "DOMICILIO_ADMINISTRADO")
    private String domicilio;

    @Column(name = "MEMORANDUM")
    private String memorandum;

    @Column(name = "HOJA_TRAMITE")
    private String hojaTramite;

    @Column(name = "ADMINISTRADO")
    private String administrado;

    @Column(name = "DOCUMENTO_ELEVACION")
    private String documentoElevacion;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "FECHA_RECEPCION")
    private LocalDateTime fechaRecepcion;

    @Column(name = "FECHA_ATENCION")
    private LocalDateTime fechaAtencion;

    @Column(name = "USUARIO_CREA_AUDITORIA")
    private String usuarioCrea;

    @Column(name = "USUARIO_ACTUALIZA_AUDITORIA")
    private String usuarioActualiza;

    @Column(name = "FECHA_CREA_AUDITORIA")
    private LocalDateTime fechaCreacion;

    @Column(name = "FECHA_ACTUALIZA_AUDITORIA")
    private LocalDateTime fechaActualizacion;

    @Column(name = "ACTIVO")
    private Integer activo;


    @Column(name = "CODIGO_ESTADO")
    private Integer codigoEstado;
    @Column(name = "CODIGO_OFICINA")
    private Integer codigoOficina;
    @Column(name = "CODIGO_SECTOR")
    private Integer codigoSector;

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESTADO", insertable = false, updatable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "CODIGO_OFICINA", insertable = false, updatable = false)
    private OficinaProveniente oficinaProveniente;

    @ManyToOne
    @JoinColumn(name = "CODIGO_SECTOR", insertable = false, updatable = false)
    private SectorEconomico sectorEconomico;

    @OneToMany(mappedBy = "expediente" ,cascade = {CascadeType.ALL})
    private List<ExpedienteVocal> vocales;

    public List<ExpedienteVocal> getVocales() {
        return vocales;
    }

    public void setVocales(List<ExpedienteVocal> vocales) {
        this.vocales = vocales;
    }

    public String getHojaTramite() {
        return hojaTramite;
    }

    public void setHojaTramite(String hojaTramite) {
        this.hojaTramite = hojaTramite;
    }

    public String getAdministrado() {
        return administrado;
    }

    public void setAdministrado(String administrado) {
        this.administrado = administrado;
    }

    public String getDocumentoElevacion() {
        return documentoElevacion;
    }

    public void setDocumentoElevacion(String documentoElevacion) {
        this.documentoElevacion = documentoElevacion;
    }

    public Integer getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCodigoExpediente(Integer codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(String memorandum) {
        this.memorandum = memorandum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDateTime getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDateTime fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
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

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Integer getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(Integer codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public Integer getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public OficinaProveniente getOficinaProveniente() {
        return oficinaProveniente;
    }

    public void setOficinaProveniente(OficinaProveniente oficinaProveniente) {
        this.oficinaProveniente = oficinaProveniente;
    }

    public SectorEconomico getSectorEconomico() {
        return sectorEconomico;
    }

    public void setSectorEconomico(SectorEconomico sectorEconomico) {
        this.sectorEconomico = sectorEconomico;
    }
}
