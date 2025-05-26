package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rol;
import com.example.demo.repository.RolRepository;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }
    
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerRolPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Rol actualizarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
