package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="usuario_fotos")
public class UsuarioFotos {
    @Id
    @Column(name="id_usuario_fotos")
    private Integer idUsuarioFotos;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name="id_foto")
    private Fotos idFoto;

    public Integer getIdUsuarioFotos() {
        return idUsuarioFotos;
    }

    public void setIdUsuarioFotos(Integer idUsuarioFotos) {
        this.idUsuarioFotos = idUsuarioFotos;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Fotos getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Fotos idFoto) {
        this.idFoto = idFoto;
    }
}
