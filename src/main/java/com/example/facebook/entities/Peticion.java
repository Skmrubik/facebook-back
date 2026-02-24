package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="peticion")
public class Peticion {
    @Id
    @Column(name="id_peticion")
    private Integer idPeticion;

    @ManyToOne
    @JoinColumn(name="id_usuario1")
    private Usuario idUsuario1;

    @ManyToOne
    @JoinColumn(name="id_usuario2")
    private Usuario idUsuario2;

    public Integer getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Integer idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }
}
