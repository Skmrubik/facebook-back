package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Query(value="SELECT * FROM publicacion order by id_publicacion DESC", nativeQuery=true)
    public List<Publicacion> getPublicacionesOrdenadas();

    @Query(value="SELECT * FROM public.publicacion where id_usuario1 = ?1 order by id_publicacion desc;", nativeQuery=true)
    public List<Publicacion> getPublicacionesOrdenadasByUser(Integer id);
}
