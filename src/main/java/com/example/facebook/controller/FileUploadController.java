package com.example.facebook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
public class FileUploadController {

    @Value("${storage.location}")
    private String storagePath;

    @PostMapping(value= "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> subirArchivo(@RequestParam(value = "file") MultipartFile file) {
        try {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Archivo vacío");
            respuesta.put("status", "ok");
            // 1. Validar que no esté vacío
            if (file.isEmpty()) return ResponseEntity.badRequest().build();

            // 2. OPCIÓN A: Guardar en el Sistema de Archivos (Recomendado)
            byte[] bytes = file.getBytes();
            Path path = Paths.get(storagePath + file.getOriginalFilename());
            System.out.println("PATH "+ path.toString());
            Files.write(path, bytes);

            // 3. OPCIÓN B: Guardar en la DB (Postgres) como bytea
            // imagenRepository.save(new ImagenEntity(file.getOriginalFilename(), bytes));
            respuesta.clear();
            respuesta.put("mensaje", "Imagen subida con éxito");
            respuesta.put("status", "ok");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
