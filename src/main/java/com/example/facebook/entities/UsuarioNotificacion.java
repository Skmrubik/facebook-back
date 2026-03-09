package com.example.facebook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="usuario_notificacion")
public class UsuarioNotificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario_notificacion")
    private Integer idUsuarioNotificacion;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario idUsuario;

    @JoinColumn(name="texto")
    private String texto;

    @JoinColumn(name="url")
    private String url;

    @Column(name="tipo")
    private Integer tipo;

    @Column(name="leido")
    private Boolean leido;

    public Integer getIdUsuarioNotificacion() {
        return idUsuarioNotificacion;
    }

    public void setIdUsuarioNotificacion(Integer idUsuarioNotificacion) {
        this.idUsuarioNotificacion = idUsuarioNotificacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
