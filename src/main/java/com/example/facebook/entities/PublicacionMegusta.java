package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="publicacion_megusta")
public class PublicacionMegusta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_publicacion_megusta")
    private Integer idPublicacionMegusta;

    @ManyToOne
    @JoinColumn(name="id_publicacion")
    private Publicacion idPublicacion;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario idUsuario;

    public Integer getIdPublicacionMegusta() {
        return idPublicacionMegusta;
    }

    public void setIdPublicacionMegusta(Integer idPublicacionMegusta) {
        this.idPublicacionMegusta = idPublicacionMegusta;
    }

    public Publicacion getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Publicacion idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
