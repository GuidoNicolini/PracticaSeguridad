package com.seguridadjwt.seguridad.controllers;


import com.seguridadjwt.seguridad.dtos.MensajeDTO;
import com.seguridadjwt.seguridad.models.Mensaje;
import com.seguridadjwt.seguridad.services.interfaces.MensajeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mensaje")
public class MensajeController {

    @Autowired
    private  final MensajeService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Mensaje> createMensaje(@Valid @RequestBody MensajeDTO mensajeDto){

        return ResponseEntity.ok(service.createMensaje(mensajeDto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Mensaje> getMensaje(@PathVariable("id") Long id){

        return ResponseEntity.ok(service.getMensaje(id));
    }


    @PatchMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Mensaje> updateMensaje(@Valid @RequestBody MensajeDTO mensajeDto,@PathVariable("id") Long id){

        return ResponseEntity.ok(service.updateMensaje(mensajeDto,id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteMensaje(@PathVariable("id") Long id){

        service.deleteMensaje(id);

        return ResponseEntity.ok("Mensaje Borrado");
    }


}
