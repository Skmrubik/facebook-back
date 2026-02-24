package com.example.facebook.repositories;

import com.example.facebook.entities.Amigos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmigosRepository extends JpaRepository<Amigos, Integer> {
}
