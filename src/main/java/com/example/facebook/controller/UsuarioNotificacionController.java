package com.example.facebook.controller;

import com.example.facebook.dto.EnvioNotificacion;
import com.example.facebook.dto.PublicacionInicio;
import com.example.facebook.entities.*;
import com.example.facebook.repositories.UsuarioNotificacionRepository;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioNotificacionController {

    @Autowired
    UsuarioNotificacionRepository usuarioNotificacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

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

    @GetMapping("/getNotificacionesUsuario")
    private ResponseEntity<List<UsuarioNotificacion>> getNotificacionesUsuario(@RequestParam String idUsuario){
        try {
            Integer id = Integer.parseInt(idUsuario);
            List<UsuarioNotificacion> usuarioNotificacions = usuarioNotificacionRepository.getNotificacionesUsuario(id);
            return new ResponseEntity<>(usuarioNotificacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardarNotificacion")
    private ResponseEntity<Integer> publicar(@RequestBody EnvioNotificacion not){
        try {
            UsuarioNotificacion notificacion = new UsuarioNotificacion();
            Usuario usuario = usuarioRepository.findUsuarioByIdUsuario(not.getIdUsuario());
            notificacion.setTexto(not.getTexto());
            notificacion.setTipo(not.getTipo());
            notificacion.setLeido(not.getLeido());
            notificacion.setIdUsuario(usuario);
            notificacion.setUrl(not.getUrl());
            UsuarioNotificacion n = usuarioNotificacionRepository.save(notificacion);
            return new ResponseEntity<>(n.getIdUsuarioNotificacion(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
