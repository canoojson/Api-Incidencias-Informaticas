package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estado;
import com.example.demo.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado) {
        Estado nuevoEstado = estadoService.crearEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstado);
    }

    @GetMapping
    public List<Estado> obtenerTodosLosEstados() {
        return estadoService.obtenerTodosLosEstados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable Integer id) {
        Optional<Estado> estado = estadoService.obtenerEstadoPorId(id);
        return estado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(@PathVariable Integer id, @RequestBody Estado detallesEstado) {
        Optional<Estado> estadoExistente = estadoService.obtenerEstadoPorId(id);
        if (estadoExistente.isPresent()) {
            Estado estado = estadoExistente.get();
            estado.setDescrip(detallesEstado.getDescrip());
            Estado estadoActualizado = estadoService.actualizarEstado(estado);
            return ResponseEntity.ok(estadoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Integer id) {
        Optional<Estado> estado = estadoService.obtenerEstadoPorId(id);
        if (estado.isPresent()) {
            estadoService.eliminarEstado(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}