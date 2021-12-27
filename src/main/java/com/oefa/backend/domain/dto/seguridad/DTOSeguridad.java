package com.oefa.backend.domain.dto.seguridad;

public class DTOSeguridad {
    public Boolean valido;
    public String mensaje;

    public DTOSeguridad(Boolean valido, String mensaje) {
        this.valido = valido;
        this.mensaje = mensaje;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
