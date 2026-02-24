package com.example.facebook.controller;

import com.example.facebook.entities.Fotos;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.FotosRepository;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FotosController {

    @Autowired
    FotosRepository fotosRepository;

    @GetMapping("/listFotos")
    private ResponseEntity<List<Fotos>> listFotos(){
        try {
            List<Fotos> fotos = fotosRepository.findAll();
            return new ResponseEntity<>(fotos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
