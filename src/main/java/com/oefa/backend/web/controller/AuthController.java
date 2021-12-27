package com.oefa.backend.web.controller;

import com.oefa.backend.domain.dto.seguridad.DTOSeguridad;
import com.oefa.backend.domain.dto.seguridad.SeguridadDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/seguridad")
public class AuthController {

    @PostMapping("/confirmacion")
    public ResponseEntity<DTOSeguridad> authSeguridad(@RequestBody SeguridadDTO seguridadDTO) {
        try {
            byte[] cadenaEncriptada = seguridadDTO.token.getBytes(StandardCharsets.ISO_8859_1);
            seguridadDTO.setToken(new String(Base64.decodeBase64(cadenaEncriptada)));

            String cadena = seguridadDTO.geteIdUsuario() + ',' +seguridadDTO.getuCodUsuario() + ','+seguridadDTO.getToken();
            byte[] encodeMessage = Base64.encodeBase64(cadena.getBytes(StandardCharsets.ISO_8859_1));
            return new ResponseEntity<>(
                    new DTOSeguridad(true, new String(encodeMessage) ),
                    HttpStatus.OK
            );
        }catch (IllegalStateException e ) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new DTOSeguridad(false, "token con formato inválido" ),
                    HttpStatus.CONFLICT
            );
        }

    }
}



