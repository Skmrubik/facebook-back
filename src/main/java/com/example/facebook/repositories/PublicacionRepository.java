package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Transactional
    @Query(value="SELECT * FROM publicacion order by id_publicacion DESC", nativeQuery=true)
    public List<Publicacion> getPublicacionesOrdenadas();

    @Query(value="select * from publicacion where id_usuario1 in (select id_usuario2 from amigos where id_usuario1 = ?1 and aceptado = true) order by id_publicacion DESC", nativeQuery=true)
    public List<Publicacion> getPublicacionesAmigosOrdenadas(Integer idUsuario);

    @Query(value="SELECT * FROM public.publicacion where id_usuario1 = ?1 order by id_publicacion desc;", nativeQuery=true)
    public List<Publicacion> getPublicacionesOrdenadasByUser(Integer id);

    Publicacion findPublicacionByIdPublicacion(Integer idPublicacion);
}
