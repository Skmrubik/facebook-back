package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="fotos_megusta")
public class FotosMegusta {
    @Id
    @Column(name="id_fotos_megusta")
    private Integer idFotosMegusta;

    @ManyToOne
    @JoinColumn(name="id_foto")
    private Fotos idFoto;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario idUsuario;

    public Integer getIdFotosMegusta() {
        return idFotosMegusta;
    }

    public void setIdFotosMegusta(Integer idFotosMegusta) {
        this.idFotosMegusta = idFotosMegusta;
    }

    public Fotos getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Fotos idFoto) {
        this.idFoto = idFoto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
