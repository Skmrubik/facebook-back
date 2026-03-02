package com.example.facebook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/imagenes")
public class ImageController {

    @Value("${storage.location}")
    private String storagePath;

    @GetMapping("/{nombreArchivo}")
    public ResponseEntity<Resource> descargarImagen(@PathVariable String nombreArchivo) {
        try {
            // 1. Aquí podrías buscar en la DB la ruta real.
            // Supongamos que tu ruta base externa es esta:
            //String rutaBaseExterna = "C:/usuarios/fotos/proyecto/";
            Path path = Paths.get(storagePath).resolve(nombreArchivo);

            Resource recurso = new UrlResource(path.toUri());

            if (recurso.exists() || recurso.isReadable()) {
                // Detectar el tipo de contenido (jpg, png, etc.)
                String contentType = Files.probeContentType(path);

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .body(recurso);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
