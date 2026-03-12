package com.example.facebook.controller;

import com.example.facebook.dto.Registro;
import com.example.facebook.entities.Amigos;
import com.example.facebook.entities.Fotos;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.AmigosRepository;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AmigosController {

    @Autowired
    AmigosRepository amigosRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

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

    @GetMapping("/getSolicitudes")
    private ResponseEntity<List<Amigos>> listAmigos(@RequestParam String id){
        try {
            Integer idUsuario = Integer.parseInt(id);
            List<Amigos> amigos = amigosRepository.getSolicitudesAmistad(idUsuario);
            return new ResponseEntity<>(amigos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarAmigo")
    private ResponseEntity<Boolean> listAmigos(@RequestParam String id1, @RequestParam String id2){
        try {
            boolean encontrado= true;
            Integer idUsuario1 = Integer.parseInt(id1);
            Integer idUsuario2 = Integer.parseInt(id2);
            Optional<Amigos> amigos = amigosRepository.getAmistad(idUsuario1, idUsuario2);
            if (amigos.isEmpty()) {
                encontrado=false;
            }
            return new ResponseEntity<>(encontrado, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarEnvioAmistad")
    private ResponseEntity<Boolean> envioAmistad(@RequestParam String id1, @RequestParam String id2){
        try {
            boolean encontrado= true;
            Integer idUsuario1 = Integer.parseInt(id1);
            Integer idUsuario2 = Integer.parseInt(id2);
            Optional<Amigos> amigos = amigosRepository.getEnvioAmistad(idUsuario1, idUsuario2);
            if (amigos.isEmpty()) {
                encontrado=false;
            }
            return new ResponseEntity<>(encontrado, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAmigos")
    private ResponseEntity<List<Amigos>> envioAmistad(@RequestParam String id){
        try {
            Integer idUsuario1 = Integer.parseInt(id);
            List<Amigos> amigos = amigosRepository.getAmigos(idUsuario1);
            return new ResponseEntity<>(amigos, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/aceptarSolicitud")
    private ResponseEntity<Boolean> aceptarSolicitud(@RequestParam String id){
        try {
            Integer idAmigos = Integer.parseInt(id);
            Amigos amigos = amigosRepository.findAmigosByIdAmigos(idAmigos);
            amigos.setAceptado(true);
            amigosRepository.save(amigos);
            Amigos amigosViceversa = new Amigos();
            amigosViceversa.setIdUsuario1(amigos.getIdUsuario2());
            amigosViceversa.setIdUsuario2(amigos.getIdUsuario1());
            amigosViceversa.setAceptado(true);
            amigosRepository.save(amigosViceversa);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/solicitudAmistad")
    private ResponseEntity<Boolean> solicitudAmistad(@RequestParam String id1, @RequestParam String id2){
        try {
            Integer idUsuario1 = Integer.parseInt(id1);
            Usuario usuario1 = usuarioRepository.findUsuarioByIdUsuario(idUsuario1);
            Integer idUsuario2 = Integer.parseInt(id2);
            Usuario usuario2 = usuarioRepository.findUsuarioByIdUsuario(idUsuario2);
            Amigos amigos = new Amigos();
            amigos.setIdUsuario1(usuario1);
            amigos.setIdUsuario2(usuario2);
            amigos.setAceptado(false);
            amigosRepository.save(amigos);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
