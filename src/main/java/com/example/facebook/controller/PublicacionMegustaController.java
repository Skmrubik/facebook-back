package com.example.facebook.controller;

import com.example.facebook.entities.PublicacionMegusta;
import com.example.facebook.repositories.PublicacionMegustaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublicacionMegustaController {

    @Autowired
    PublicacionMegustaRepository publicacionMegustaRepository;

    @GetMapping("/listPublicacionesMegusta")
    private ResponseEntity<List<PublicacionMegusta>> listPublicacionesMegusta(){
        try {
            List<PublicacionMegusta> publicacionesMegustas = publicacionMegustaRepository.findAll();
            return new ResponseEntity<>(publicacionesMegustas, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
