package com.example.facebook.controller;

import com.example.facebook.dto.Registro;
import com.example.facebook.entities.Usuario;
import com.example.facebook.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ResponseEntity<Boolean> login(@RequestParam String nombre, @RequestParam String password){
        try {
            Usuario user = usuarioRepository.findUsuarioByCorreo(nombre);
            if (password.equals(user.getPassword())){
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registrarUsuario")
    private ResponseEntity<Boolean> listUsuarios(@RequestBody Registro registro){
        try {
            System.out.println(registro.getNombre());
            Usuario usuario = new Usuario();
            usuario.setNombre(registro.getNombre());
            usuario.setCorreo(registro.getCorreo());
            usuario.setPassword(registro.getPassword());
            usuario.setLugar(registro.getLugar());
            usuario.setPathFotoPerfil(null);
            usuarioRepository.save(usuario);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
