package com.example.demo.service;




import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    
    public Profesor crearProfesor(Profesor profesor) {
    	profesor.setPwd(HashUtil.md5(profesor.getPwd()));
        return profesorRepository.save(profesor);
    }

    
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    
    public Optional<Profesor> obtenerProfesorPorId(Integer id) {
        return profesorRepository.findById(id);
    }
    

    
    public Profesor actualizarProfesor(Profesor profesor) {
    	return profesorRepository.save(profesor);
    }

    
    public void eliminarProfesor(Integer id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Profesor no encontrado");
        }
    }
    
    
    public List<Profesor> obtenerProfesoresPorDepartamento(String nombre) {
        return profesorRepository.findProfesoresByDepartamento(nombre);
    }
    public List<Object[]> getProfesoresByRol(String nombreRol) {
        return profesorRepository.findProfesoresByRol(nombreRol);
    }
    public Profesor validarInicioSesion(String username, String pwd) {
    	return profesorRepository.validarInicioSesion(username, pwd);
    }
}