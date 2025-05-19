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

import com.example.demo.model.TiposHw;
import com.example.demo.service.TiposHwService;

@RestController
@RequestMapping("/api/tiposhw")
public class TiposHwController {

    @Autowired
    private TiposHwService tiposHwService;

    @PostMapping
    public ResponseEntity<TiposHw> creartipoHw(@RequestBody TiposHw tiposHw) {
    	TiposHw nuevaIncidencia = tiposHwService.crearTipoHw(tiposHw);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaIncidencia);
    }
    // Read all
    @GetMapping
    public List<TiposHw> obtenerTodosLostipoHw() {
        return tiposHwService.obtenerTodosLosTipoHw();
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<TiposHw> obtenertipoHwPorId(@PathVariable Integer id) {
        Optional<TiposHw> tiposHw = tiposHwService.obtenerTipoHwPorId(id);
        return tiposHw.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<TiposHw> actualizartiposHw(@PathVariable Integer id, @RequestBody TiposHw detallesIncidencia) {
        Optional<TiposHw> tipoHwExistente = tiposHwService.obtenerTipoHwPorId(id);
        if (tipoHwExistente.isPresent()) {
        	TiposHw tiposHw = tipoHwExistente.get();
            tiposHw.setIncidenciasHardware(detallesIncidencia.getIncidenciasHardware());
            tiposHw.setDescrip(detallesIncidencia.getDescrip());
            TiposHw tipoHwActualizado = tiposHwService.actualizarTipoHw(tiposHw);
            return ResponseEntity.ok(tipoHwActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Integer id) {
        Optional<TiposHw> incidencia = tiposHwService.obtenerTipoHwPorId(id);
        if (incidencia.isPresent()) {
        	tiposHwService.eliminarTipoHw(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
