package com.example.facebook.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="lugar")
    private String lugar;

    @Column(name="path_foto_perfil")
    private String pathFotoPerfil;

    @Column(name="nombre")
    private String nombre;

    @Column(name="correo")
    private String correo;

    @Column(name="password")
    private String password;

    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPathFotoPerfil() {
        return pathFotoPerfil;
    }

    public void setPathFotoPerfil(String pathFotoPerfil) {
        this.pathFotoPerfil = pathFotoPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
