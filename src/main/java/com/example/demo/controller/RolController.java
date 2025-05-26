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

import com.example.demo.model.Rol;
import com.example.demo.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.crearRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.obtenerRolPorId(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol detallesRol) {
        Optional<Rol> rolExistente = rolService.obtenerRolPorId(id);
        if (rolExistente.isPresent()) {
            Rol rol = rolExistente.get();
            rol.setDescrip(detallesRol.getDescrip());
            rol.setPermisos(detallesRol.getPermisos()); // También actualizamos los permisos
            Rol rolActualizado = rolService.actualizarRol(rol);
            return ResponseEntity.ok(rolActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.obtenerRolPorId(id);
        if (rol.isPresent()) {
            rolService.eliminarRol(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
