package com.example.facebook.repositories;

import com.example.facebook.entities.Amigos;
import com.example.facebook.entities.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmigosRepository extends JpaRepository<Amigos, Integer> {

    @Query(value="select * from amigos where id_usuario1 = ?1 and aceptado = false", nativeQuery=true)
    public List<Amigos> getSolicitudesAmistad(Integer idUsuario);
}
