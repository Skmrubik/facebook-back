package com.example.facebook.dto;

public class Registro {
    private String nombre;
    private String lugar;
    private String correo;
    private String password;

    public Registro() {
    }

    public Registro(String nombre, String lugar, String correo, String password) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.correo = correo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
