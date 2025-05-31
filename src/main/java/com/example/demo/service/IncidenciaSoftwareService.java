package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IncidenciaSoftware;
import com.example.demo.repository.IncidenciaSoftwareRepository;

@Service
public class IncidenciaSoftwareService {

    @Autowired
    private IncidenciaSoftwareRepository softwareRepository;

    public IncidenciaSoftware crear(IncidenciaSoftware incidenciaSoftware) {
        return softwareRepository.save(incidenciaSoftware);
    }

    public Optional<IncidenciaSoftware> obtenerPorId(Integer id) {
        return softwareRepository.findById(id);
    }
    

    public List<IncidenciaSoftware> obtenerTodas() {
        return softwareRepository.findAll();
    }

    public IncidenciaSoftware actualizar(IncidenciaSoftware incidenciaSoftware) {
        return softwareRepository.save(incidenciaSoftware);
    }

    public void eliminar(Integer id) {
        softwareRepository.deleteById(id);
    }
}

