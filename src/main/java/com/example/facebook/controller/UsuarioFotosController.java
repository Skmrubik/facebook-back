package com.example.facebook.controller;

import com.example.facebook.entities.Amigos;
import com.example.facebook.entities.UsuarioFotos;
import com.example.facebook.repositories.UsuarioFotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioFotosController {

    @Autowired
    UsuarioFotosRepository usuarioFotosRepository;

    @GetMapping("/listUsuarioFotos")
    private ResponseEntity<List<UsuarioFotos>> listUsuarioFotos(){
        try {
            List<UsuarioFotos> usuarioFotos = usuarioFotosRepository.findAll();
            return new ResponseEntity<>(usuarioFotos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
