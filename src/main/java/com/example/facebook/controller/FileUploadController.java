package com.example.facebook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
public class FileUploadController {

    @Value("${storage.location}")
    private String storagePath;

    @PostMapping(value= "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> subirArchivo(@RequestParam(value = "file") MultipartFile file) {
        try {
            // 1. Validar que no esté vacío
            if (file.isEmpty()) return ResponseEntity.badRequest().body("Archivo vacío");

            // 2. OPCIÓN A: Guardar en el Sistema de Archivos (Recomendado)
            byte[] bytes = file.getBytes();
            Path path = Paths.get(storagePath + file.getOriginalFilename());
            System.out.println("PATH "+ path.toString());
            Files.write(path, bytes);

            // 3. OPCIÓN B: Guardar en la DB (Postgres) como bytea
            // imagenRepository.save(new ImagenEntity(file.getOriginalFilename(), bytes));

            return ResponseEntity.ok("Imagen subida con éxito: " + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al subir el archivo");
        }
    }
}
