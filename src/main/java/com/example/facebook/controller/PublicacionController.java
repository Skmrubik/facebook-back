package com.example.facebook.controller;

import com.example.facebook.dto.PublicacionInicio;
import com.example.facebook.dto.PublicacionPerfil;
import com.example.facebook.dto.Registro;
import com.example.facebook.entities.*;
import com.example.facebook.repositories.*;
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

    @Autowired
    UsuarioNotificacionRepository usuarioNotificacionRepository;

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

    @PostMapping("/publicarPerfil")
    private ResponseEntity<Integer> publicarPerfil(@RequestBody PublicacionPerfil pub){
        try {
            Publicacion publicacion = new Publicacion();
            Usuario usuario1 = usuarioRepository.findUsuarioByIdUsuario(pub.getIdUsuario1());
            Usuario usuario2 = usuarioRepository.findUsuarioByIdUsuario(pub.getIdUsuario2());
            publicacion.setIdUsuario1(usuario1);
            publicacion.setIdUsuario2(usuario2);
            publicacion.setTexto(pub.getTexto());
            publicacion.setFecha(pub.getFecha());
            if (pub.getIdFoto()!=null){
                Fotos foto = fotosRepository.findFotosByIdFoto(pub.getIdFoto());
                publicacion.setIdFoto(foto);
            } else {
                publicacion.setIdFoto(null);
            }
            Publicacion p = publicacionRepository.save(publicacion);
            UsuarioNotificacion usuarioNotificacion = new UsuarioNotificacion();
            usuarioNotificacion.setLeido(false);
            usuarioNotificacion.setIdUsuario(usuario1);
            usuarioNotificacion.setTipo(2);
            usuarioNotificacion.setTexto(usuario2.getNombre()+" ha escrito en tu tablón.");
            usuarioNotificacion.setUrl("/Perfil/"+usuario1.getIdUsuario());
            usuarioNotificacionRepository.save(usuarioNotificacion);
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
