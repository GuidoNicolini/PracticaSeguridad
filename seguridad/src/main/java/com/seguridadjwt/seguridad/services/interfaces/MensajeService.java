package com.seguridadjwt.seguridad.services.interfaces;

import com.seguridadjwt.seguridad.dtos.MensajeDTO;
import com.seguridadjwt.seguridad.models.Mensaje;

public interface MensajeService {

    Mensaje createMensaje(MensajeDTO mensajeDto);
    Mensaje getMensaje(Long id);
    Mensaje updateMensaje(MensajeDTO mensajeDto, Long id);

    void deleteMensaje(Long id);

}
