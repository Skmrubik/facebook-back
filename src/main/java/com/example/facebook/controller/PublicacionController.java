package com.example.facebook.controller;

import com.example.facebook.entities.Publicacion;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicacionController {

    @Autowired
    PublicacionRepository publicacionRepository;

    @GetMapping("/listPublicaciones")
    private ResponseEntity<List<Publicacion>> listPubilicaciones(){
        try {
            List<Publicacion> publicacions = publicacionRepository.findAll();
            return new ResponseEntity<>(publicacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
