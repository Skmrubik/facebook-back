package com.example.facebook.controller;

import com.example.facebook.dto.PublicacionInicio;
import com.example.facebook.dto.Registro;
import com.example.facebook.entities.Fotos;
import com.example.facebook.entities.Publicacion;
import com.example.facebook.entities.PublicacionMegusta;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.FotosRepository;
import com.example.facebook.repositories.PublicacionMegustaRepository;
import com.example.facebook.repositories.PublicacionRepository;
import com.example.facebook.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicacionController {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FotosRepository fotosRepository;

    @Autowired
    PublicacionMegustaRepository publicacionMegustaRepository;

    @GetMapping("/listPublicaciones")
    private ResponseEntity<List<Publicacion>> listPubilicaciones(){
        try {
            List<Publicacion> publicacions = publicacionRepository.getPublicacionesOrdenadas();
            return new ResponseEntity<>(publicacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listPublicacionesAmigos")
    private ResponseEntity<List<Publicacion>> listPubilicaciones(@RequestParam String idUsu){
        try {
            Integer idUsuario = Integer.parseInt(idUsu);
            List<Publicacion> publicacions = publicacionRepository.getPublicacionesAmigosOrdenadas(idUsuario);
            return new ResponseEntity<>(publicacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listPublicacionesByUser")
    private ResponseEntity<List<Publicacion>> listPubilicacionesByUser(@RequestParam String id){
        try {
            Integer idUser = Integer.parseInt(id);
            List<Publicacion> publicacions = publicacionRepository.getPublicacionesOrdenadasByUser(idUser);
            return new ResponseEntity<>(publicacions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPublicacionById")
    private ResponseEntity<Publicacion> getPublicacionById(@RequestParam String id){
        try {
            Integer idPub = Integer.parseInt(id);
            Publicacion publicacion = publicacionRepository.findPublicacionByIdPublicacion(idPub);
            return new ResponseEntity<>(publicacion, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/publicarInicio")
    private ResponseEntity<Integer> publicar(@RequestBody PublicacionInicio pub){
        try {
            Publicacion publicacion = new Publicacion();
            Usuario usuario = usuarioRepository.findUsuarioByIdUsuario(pub.getIdUsuario());
            publicacion.setIdUsuario1(usuario);
            publicacion.setIdUsuario2(null);
            publicacion.setTexto(pub.getTexto());
            publicacion.setFecha(pub.getFecha());
            if (pub.getIdFoto()!=null){
                Fotos foto = fotosRepository.findFotosByIdFoto(pub.getIdFoto());
                publicacion.setIdFoto(foto);
            } else {
                publicacion.setIdFoto(null);
            }
            Publicacion p = publicacionRepository.save(publicacion);
            return new ResponseEntity<>(p.getIdPublicacion(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/borrarPublicacion")
    private ResponseEntity<Boolean> borrarPublicacion(@RequestParam String id){
        try {
            Integer idPub = Integer.parseInt(id);
            publicacionMegustaRepository.borrarMeGustasPublicacion(idPub);
            publicacionRepository.deleteById(idPub);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
