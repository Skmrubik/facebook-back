package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import com.example.facebook.entities.UsuarioNotificacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioNotificacionRepository extends JpaRepository<UsuarioNotificacion,Integer> {
    @Transactional
    @Query(value="select * from usuario_notificacion where id_usuario = ?1 and leido = false", nativeQuery=true)
    public List<UsuarioNotificacion> getNotificacionesUsuario(Integer idUsuario);

    public UsuarioNotificacion findUsuarioNotificacionByIdUsuarioNotificacion(Integer usuarioNotificacion);
}
