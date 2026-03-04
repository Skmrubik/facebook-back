package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="fotos")
public class Fotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_foto")
    private Integer idFoto;

    @Column(name="path")
    private String path;

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
