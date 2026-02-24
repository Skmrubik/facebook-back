package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="publicacion")
public class Publicacion {
    @Id
    @Column(name="id_publicacion")
    private Integer idPublicacion;

    @ManyToOne
    @JoinColumn(name="id_usuario1")
    private Usuario idUsuario1;

    @ManyToOne
    @JoinColumn(name="id_usuario2")
    private Usuario idUsuario2;

    @Column(name="texto")
    private String texto;

    @ManyToOne
    @JoinColumn(name="id_foto")
    private Fotos idFoto;

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Fotos getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Fotos idFoto) {
        this.idFoto = idFoto;
    }
}
