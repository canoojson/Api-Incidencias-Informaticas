package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.model.IncidenciaHardware;
import com.example.demo.model.IncidenciaSoftware;
import com.example.demo.service.IncidenciaSoftwareService;

@RestController
@RequestMapping("/api/incidenciasoftware")
public class IncidenciaSoftwareController {

    @Autowired
    private IncidenciaSoftwareService softwareService;

    @PostMapping
    public ResponseEntity<IncidenciaSoftware> crear(@RequestBody IncidenciaSoftware incidenciaSoftware) {
        return ResponseEntity.status(HttpStatus.CREATED).body(softwareService.crear(incidenciaSoftware));
    }

    @GetMapping
    public List<IncidenciaSoftware> obtenerTodas() {
        return softwareService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaSoftware> obtenerPorId(@PathVariable Integer id) {
        return softwareService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciaSoftware> actualizar(@PathVariable Integer id, @RequestBody IncidenciaSoftware detalles) {
        return softwareService.obtenerPorId(id)
                .map(sw -> {
                    sw.setSO(detalles.getSO());
                    sw.setSoftware(detalles.getSoftware());
                    sw.setClave(detalles.getClave());
                    return ResponseEntity.ok(softwareService.actualizar(sw));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (softwareService.obtenerPorId(id).isPresent()) {
            softwareService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

