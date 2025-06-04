package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Permiso;
import com.example.demo.model.Rol;
import com.example.demo.repository.PermisoRepository;
import com.example.demo.repository.RolRepository;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private PermisoRepository permisoRepository;
    
    
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }
    
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }
    
    public List<Permiso> obtenerTodosLosPermisos() {
        return permisoRepository.findAll();
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
