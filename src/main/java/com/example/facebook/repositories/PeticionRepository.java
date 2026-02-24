package com.example.facebook.repositories;

import com.example.facebook.entities.Peticion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeticionRepository extends JpaRepository<Peticion, Integer> {
}
