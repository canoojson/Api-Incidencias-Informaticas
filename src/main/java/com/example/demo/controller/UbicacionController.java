package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Ubicacion;
import com.example.demo.service.UbicacionService;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @PostMapping
    public ResponseEntity<Ubicacion> crearUbicacion(@RequestBody Ubicacion ubicacion) {
        Ubicacion nuevaUbicacion = ubicacionService.crearUbicacion(ubicacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaUbicacion);
    }

    @GetMapping
    public ResponseEntity<List<Ubicacion>> obtenerTodasLasUbicaciones() {
    	List<Ubicacion> ubicaciones = ubicacionService.obtenerTodasLasUbicaciones();
        return ResponseEntity.ok(ubicaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> obtenerUbicacionPorId(@PathVariable Integer id) {
        Optional<Ubicacion> ubicacion = ubicacionService.obtenerUbicacionPorId(id);
        return ubicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Ubicacion> actualizarUbicacion(@PathVariable Integer id, @RequestBody Ubicacion ubicacion) {
        try {
        	System.out.println("UBICACION: " + ubicacion.getIdUbicacion().toString());
        	Ubicacion ubicacionActualizada = ubicacionService.actualizarUbicacion(id, ubicacion);
        	return ResponseEntity.ok(ubicacionActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUbicacion(@PathVariable Integer id) {
        try {
        	ubicacionService.eliminarUbicacion(id);
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
