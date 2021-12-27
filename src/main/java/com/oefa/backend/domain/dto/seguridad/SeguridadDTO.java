package com.oefa.backend.domain.dto.seguridad;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class SeguridadDTO implements Serializable {
    public String eIdUsuario;
    public String uCodUsuario;
    public String uNombreCompleto;
    public String token;
    public String tipoPersona;
    public String numDocumento;

    public SeguridadDTO(String eIdUsuario, String uCodUsuario, String uNombreCompleto, String token, String tipoPersona, String numDocumento) {
        this.eIdUsuario = eIdUsuario;
        this.uCodUsuario = uCodUsuario;
        this.uNombreCompleto = uNombreCompleto;
        this.token = token;
        this.tipoPersona = tipoPersona;
        this.numDocumento = numDocumento;

    }
    public String desencriptarTokenSeguridad( String cadenaEncriptada) {
        byte[] cadenaCodificada = cadenaEncriptada.getBytes(StandardCharsets.ISO_8859_1);
        byte[] bytesDecodificados = Base64.decodeBase64(cadenaCodificada);
        String cadenaDecodificada = new String(bytesDecodificados);

        System.out.println("decodificado: " + cadenaDecodificada);
        return cadenaDecodificada;
    }
    public String encriptarObjeto( SeguridadDTO obj) {

        byte[] encodedAuth = SerializationUtils.serialize(obj);
        String codeString =  Base64.encodeBase64String(encodedAuth);
        System.out.println("codificada: " + codeString);
        return codeString;
    }
    public String encriptarDatosSeguridad() {
        String code = this.eIdUsuario + ',' +this.uNombreCompleto;
        byte[] encodedAuth = Base64.encodeBase64(code.getBytes(StandardCharsets.ISO_8859_1));
        String codeString = new String(encodedAuth);
        System.out.println("codificada: " + codeString);

        return codeString;
    }

    public String geteIdUsuario() {
        return eIdUsuario;
    }

    public void seteIdUsuario(String eIdUsuario) {
        this.eIdUsuario = eIdUsuario;
    }

    public String getuCodUsuario() {
        return uCodUsuario;
    }

    public void setuCodUsuario(String uCodUsuario) {
        this.uCodUsuario = uCodUsuario;
    }

    public String getuNombreCompleto() {
        return uNombreCompleto;
    }

    public void setuNombreCompleto(String uNombreCompleto) {
        this.uNombreCompleto = uNombreCompleto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

}
