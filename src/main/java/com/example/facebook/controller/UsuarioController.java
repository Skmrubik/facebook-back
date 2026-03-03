package com.example.facebook.controller;

import com.example.facebook.dto.Registro;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listUsuarios")
    private ResponseEntity<List<Usuario>> listUsuarios(){
        try {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    private ResponseEntity<Integer> login(@RequestParam String nombre, @RequestParam String password){
        try {
            Usuario user = usuarioRepository.findUsuarioByCorreo(nombre);
            if (user != null && password.equals(user.getPassword())){
                return new ResponseEntity<>(user.getIdUsuario(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(-1, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pathFoto")
    private ResponseEntity<Map<String, String>> login(@RequestParam String id){
        try {
            Integer idUsuario = Integer.parseInt(id);
            Usuario user = usuarioRepository.findUsuarioByIdUsuario(idUsuario);
            Map<String, String> response = new HashMap<>();
            response.put("fileName", user.getPathFotoPerfil());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registrarUsuario")
    private ResponseEntity<Integer> registrarUsuarios(@RequestBody Registro registro){
        try {
            System.out.println(registro.getNombre());
            Usuario usuario = new Usuario();
            usuario.setNombre(registro.getNombre());
            usuario.setCorreo(registro.getCorreo());
            usuario.setPassword(registro.getPassword());
            usuario.setLugar(registro.getLugar());
            usuario.setPathFotoPerfil(registro.getPathFoto());
            Usuario user = usuarioRepository.save(usuario);
            return new ResponseEntity<>(user.getIdUsuario(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
