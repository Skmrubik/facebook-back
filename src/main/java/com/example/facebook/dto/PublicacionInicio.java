package com.example.facebook.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PublicacionInicio {
    Integer idUsuario;
    String texto;
    Integer idFoto;
    Date fecha;

    public PublicacionInicio() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
