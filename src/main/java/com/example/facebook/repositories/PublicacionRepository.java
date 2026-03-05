package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Query(value="SELECT * FROM publicacion order by id_publicacion DESC", nativeQuery=true)
    public List<Publicacion> getPublicacionesOrdenadas();

    /*@Query(value="Delete FROM publicacion where id_publicacion = ?1", nativeQuery=true)
    void borrarPublicacion(Integer id);*/
}
