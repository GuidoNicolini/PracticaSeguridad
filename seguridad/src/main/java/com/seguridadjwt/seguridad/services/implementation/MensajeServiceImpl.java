package com.seguridadjwt.seguridad.services.implementation;


import com.seguridadjwt.seguridad.dtos.MensajeDTO;
import com.seguridadjwt.seguridad.models.Mensaje;
import com.seguridadjwt.seguridad.repositories.MensajeRepository;
import com.seguridadjwt.seguridad.services.interfaces.MensajeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MensajeServiceImpl implements MensajeService {

    private final ModelMapper modelMapper;
    @Autowired
    private MensajeRepository repository;

    @Override
    @Transactional
    public Mensaje createMensaje(MensajeDTO mensajeDto) {
        Mensaje mensaje = modelMapper.map(mensajeDto, Mensaje.class);
        return repository.save(mensaje);
    }

    @Override
    @Transactional
    public Mensaje getMensaje(Long id) {
        Optional<Mensaje> respuesta = repository.findById(id);
        return respuesta.orElseThrow(() -> new EntityNotFoundException("No encontrado"));
    }

    @Override
    @Transactional
    public Mensaje updateMensaje(MensajeDTO mensajeDto, Long id) {
        try {
            Mensaje respuesta = getMensaje(id);
            respuesta.setContenido(mensajeDto.getContenido());
            return repository.save(respuesta);

        } catch (Exception e) {
            throw new RuntimeException("Failed to update contact information", e);
        }

    }

    @Override
    @Transactional
    public void deleteMensaje(Long id) {
        repository.deleteById(id);
    }
}
