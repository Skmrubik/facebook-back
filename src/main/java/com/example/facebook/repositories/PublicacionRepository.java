package com.example.facebook.repositories;

import com.example.facebook.entities.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {
}
