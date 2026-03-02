package com.example.facebook.repositories;

import com.example.facebook.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findUsuarioByCorreo(String correo);
    Usuario findUsuarioByIdUsuario(Integer id);
}
