package com.example.facebook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="fecha_nac")
    private Date fechaNac;

    @Column(name="lugar")
    private String lugar;

    @Column(name="path_foto_perfil")
    private String pathFotoPerfil;

    @Column(name="nombre")
    private String nombre;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
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
}
