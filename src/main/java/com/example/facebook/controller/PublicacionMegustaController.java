package com.example.facebook.controller;

import com.example.facebook.entities.Publicacion;
import com.example.facebook.entities.PublicacionMegusta;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.PublicacionMegustaRepository;
import com.example.facebook.repositories.PublicacionRepository;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicacionMegustaController {

    @Autowired
    PublicacionMegustaRepository publicacionMegustaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PublicacionRepository publicacionRepository;

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

    @GetMapping("/publicacionListMegusta")
    private ResponseEntity<List<PublicacionMegusta>> publicacionListMegusta(@RequestParam String idPub){
        try {
            Integer idPublicacion = Integer.parseInt(idPub);
            List<PublicacionMegusta> publicacionMegustas = publicacionMegustaRepository.getPublicacionMeGustas(idPublicacion);
            return new ResponseEntity<>(publicacionMegustas, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/meGustaPublicacion")
    private ResponseEntity<Boolean> meGustaPublicacion(@RequestParam String idUser, @RequestParam String idPub){
        try {
            Integer idUsuario = Integer.parseInt(idUser);
            Integer idPublicacion = Integer.parseInt(idPub);
            Usuario usuario = usuarioRepository.findUsuarioByIdUsuario(idUsuario);
            Publicacion publicacion = publicacionRepository.findPublicacionByIdPublicacion(idPublicacion);
            PublicacionMegusta publicacionMegusta = new PublicacionMegusta();
            publicacionMegusta.setIdUsuario(usuario);
            publicacionMegusta.setIdPublicacion(publicacion);
            publicacionMegustaRepository.save(publicacionMegusta);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getMegusta")
    private ResponseEntity<Integer> getMegusta(@RequestParam String idUser, @RequestParam String idPub){
        try {
            Integer idUsuario = Integer.parseInt(idUser);
            Integer idPublicacion = Integer.parseInt(idPub);
            Integer id = publicacionMegustaRepository.getIdPublicacionMeGusta(idPublicacion, idUsuario);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/borrarMegusta")
    private ResponseEntity<Boolean> borrarMegusta(@RequestParam String id){
        try {
            Integer idMG = Integer.parseInt(id);
            publicacionMegustaRepository.deleteById(idMG);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
