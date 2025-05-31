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

import com.example.demo.model.Incidencia;
import com.example.demo.service.IncidenciaService;


@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @PostMapping
    public ResponseEntity<Incidencia> crearincidencia(@RequestBody Incidencia incidencia) {
        Incidencia nuevaIncidencia = incidenciaService.crearIncidencia(incidencia, incidencia.getIncidenciaHardware(), incidencia.getIncidenciaSoftware());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaIncidencia);
    }
    // Read all
    @GetMapping
    public List<Incidencia> obtenerTodasLasIncidencias() {
        return incidenciaService.obtenerTodasLasIncidencias();
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> obtenerIncidenciaPorId(@PathVariable Integer id) {
        Optional<Incidencia> incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        return incidencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> actualizarIncidencia(@PathVariable Integer id, @RequestBody Incidencia detallesIncidencia) {
        Optional<Incidencia> incidenciaExistente = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidenciaExistente.isPresent()) {
        	System.out.println("AQUI HE ENTRADO CON ESTA INCIDENCIA HARDWARE/SOFTWARE" + detallesIncidencia.getIncidenciaHardware().toString() );
            Incidencia incidencia = incidenciaExistente.get();
            incidencia.setTipo(detallesIncidencia.getTipo());
            incidencia.setFecha_incidencia(detallesIncidencia.getFecha_incidencia());
            incidencia.setFecha_introduccion(detallesIncidencia.getFecha_introduccion());
            incidencia.setFecha_resolucion(detallesIncidencia.getFecha_resolucion());
            incidencia.setProfesor(detallesIncidencia.getProfesor());
            incidencia.setResponsable(detallesIncidencia.getResponsable());
            incidencia.setDepartamento(detallesIncidencia.getDepartamento());
            incidencia.setUbicacion(detallesIncidencia.getUbicacion());
            incidencia.setObservaciones(detallesIncidencia.getObservaciones());
            incidencia.setEstado(detallesIncidencia.getEstado());
            incidencia.setTiempo_invertido(detallesIncidencia.getTiempo_invertido());
            incidencia.setMas_info(detallesIncidencia.getMas_info());
            incidencia.setComentarios(detallesIncidencia.getComentarios());
            incidencia.setDescripcion(detallesIncidencia.getDescripcion());
            incidencia.setIncidenciaHardware(detallesIncidencia.getIncidenciaHardware());
            incidencia.setIncidenciaSoftware(detallesIncidencia.getIncidenciaSoftware());
            Incidencia incidenciaActualizada = incidenciaService.actualizarIncidencia(incidencia, incidencia.getIncidenciaHardware(), incidencia.getIncidenciaSoftware());
            return ResponseEntity.ok(incidenciaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Integer id) {
        Optional<Incidencia> incidencia = incidenciaService.obtenerIncidenciaPorId(id);
        if (incidencia.isPresent()) {
            incidenciaService.eliminarIncidencia(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}