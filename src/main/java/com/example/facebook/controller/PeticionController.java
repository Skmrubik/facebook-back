package com.example.facebook.controller;

import com.example.facebook.entities.Peticion;
import com.example.facebook.entities.Publicacion;
import com.example.facebook.repositories.PeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeticionController {

    @Autowired
    PeticionRepository peticionRepository;

    @GetMapping("/listPeticiones")
    private ResponseEntity<List<Peticion>> listPeticiones(){
        try {
            List<Peticion> peticiones = peticionRepository.findAll();
            return new ResponseEntity<>(peticiones, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
