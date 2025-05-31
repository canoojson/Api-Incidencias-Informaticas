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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IncidenciaHardware;
import com.example.demo.service.IncidenciaHardwareService;

@RestController
@RequestMapping("/api/incidenciahardware")
public class IncidenciaHardwareController {

    @Autowired
    private IncidenciaHardwareService hardwareService;

    @PostMapping
    public ResponseEntity<IncidenciaHardware> crear(@RequestBody IncidenciaHardware incidenciaHardware) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hardwareService.crear(incidenciaHardware));
    }

    @GetMapping
    public List<IncidenciaHardware> obtenerTodas() {
        return hardwareService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciaHardware> obtenerPorId(@PathVariable Integer id) {
        return hardwareService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciaHardware> actualizar(@PathVariable Integer id, @RequestBody IncidenciaHardware detalles) {
        return hardwareService.obtenerPorId(id)
                .map(hw -> {
                    hw.setModelo(detalles.getModelo());
                    hw.setNum_serie(detalles.getNum_serie());
                    hw.setTipoHw(detalles.getTipoHw());
                    return ResponseEntity.ok(hardwareService.actualizar(hw));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    		System.out.println("AQUI HA ENTRADO");
        if (hardwareService.obtenerPorId(id).isPresent()) {
        	System.out.println("AQUI TAMBIEN");
            hardwareService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
