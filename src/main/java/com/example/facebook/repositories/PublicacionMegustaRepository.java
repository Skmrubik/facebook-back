package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import com.example.facebook.entities.PublicacionMegusta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionMegustaRepository extends JpaRepository<PublicacionMegusta, Integer> {

    @Query(value="SELECT * FROM public.publicacion_megusta where id_publicacion = ?1", nativeQuery=true)
    public List<PublicacionMegusta> getPublicacionMeGustas(Integer idPublicacion);

    @Query(value="select id_publicacion_megusta from publicacion_megusta where id_publicacion = ?1 and id_usuario = ?2", nativeQuery=true)
    Integer getIdPublicacionMeGusta(Integer idPublicacion, Integer idUsuario);
}
