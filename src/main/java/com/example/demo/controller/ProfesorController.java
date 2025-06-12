package com.example.demo.controller;



import com.example.demo.model.Profesor;
import com.example.demo.service.HashUtil;
import com.example.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.crearProfesor(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProfesor);
    }

    
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodosLosProfesores() {
        List<Profesor> profesores = profesorService.obtenerTodosLosProfesores();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/departamento/{nombre}")
    public ResponseEntity<List<Profesor>> obtenerProfesoresPorDepartamento(@PathVariable String nombre) {
        List<Profesor> profesores = profesorService.obtenerProfesoresPorDepartamento(nombre);
        return ResponseEntity.ok(profesores);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Integer id) {
        Optional<Profesor> pofesor = profesorService.obtenerProfesorPorId(id);
        return pofesor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Integer id, @RequestBody Profesor detallesProfesor) {
    	System.out.println("ENTRO AQUI" + detallesProfesor.getPwd());
        Optional<Profesor> profesorExistente = profesorService.obtenerProfesorPorId(id);       
        if (profesorExistente.isPresent()) {
            Profesor profesor = profesorExistente.get();
            String pwdOriginal = profesor.getPwd();
            String pwdNueva = detallesProfesor.getPwd();
            profesor.setNombre(detallesProfesor.getNombre());
            profesor.setApellidos(detallesProfesor.getApellidos());
            profesor.setDepartamento(detallesProfesor.getDepartamento());
            profesor.setEmail(detallesProfesor.getEmail());
            profesor.setDni(detallesProfesor.getDni());
            if (!pwdOriginal.equals(pwdNueva)) {
                profesor.setPwd(HashUtil.md5(pwdNueva));
            } else {
                profesor.setPwd(pwdOriginal); // o directamente no lo toques
            }
            profesor.setRol(detallesProfesor.getRol());
            profesor.setUsername(detallesProfesor.getUsername());
            Profesor profesorActualizado = profesorService.actualizarProfesor(profesor);
            return ResponseEntity.ok(profesorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
