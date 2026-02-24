package com.example.facebook.controller;

import com.example.facebook.entities.FotosMegusta;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.FotosMegustaRepository;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FotosMegustaController {

    @Autowired
    FotosMegustaRepository fotosMegustaRepository;

    @GetMapping("/listFotosMegusta")
    private ResponseEntity<List<FotosMegusta>> listFotosMegusta(){
        try {
            List<FotosMegusta> fotosMegustas = fotosMegustaRepository.findAll();
            return new ResponseEntity<>(fotosMegustas, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
