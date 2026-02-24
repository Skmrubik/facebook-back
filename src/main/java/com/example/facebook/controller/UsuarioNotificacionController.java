package com.example.facebook.controller;

import com.example.facebook.entities.UsuarioFotos;
import com.example.facebook.entities.UsuarioNotificacion;
import com.example.facebook.repositories.UsuarioNotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioNotificacionController {

    @Autowired
    UsuarioNotificacionRepository usuarioNotificacionRepository;

    @GetMapping("/listUsuarioNotificacion")
    private ResponseEntity<List<UsuarioNotificacion>> listUsuarioNotificacion(){
        try {
            List<UsuarioNotificacion> usuarioNotificacions = usuarioNotificacionRepository.findAll();
            return new ResponseEntity<>(usuarioNotificacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
