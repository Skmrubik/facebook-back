package com.example.facebook.controller;

import com.example.facebook.entities.Amigos;
import com.example.facebook.entities.Fotos;
import com.example.facebook.repositories.AmigosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmigosController {

    @Autowired
    AmigosRepository amigosRepository;

    @GetMapping("/listAmigos")
    private ResponseEntity<List<Amigos>> listAmigos(){
        try {
            List<Amigos> amigos = amigosRepository.findAll();
            return new ResponseEntity<>(amigos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
