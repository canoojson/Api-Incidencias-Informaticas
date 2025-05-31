package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IncidenciaHardware;
import com.example.demo.repository.IncidenciaHardwareRepository;

@Service
public class IncidenciaHardwareService {

    @Autowired
    private IncidenciaHardwareRepository hardwareRepository;

    public IncidenciaHardware crear(IncidenciaHardware incidenciaHardware) {
        return hardwareRepository.save(incidenciaHardware);
    }

    public Optional<IncidenciaHardware> obtenerPorId(Integer id) {
        return hardwareRepository.findById(id);
    }
    
    
    public List<IncidenciaHardware> obtenerTodas() {
        return hardwareRepository.findAll();
    }

    public IncidenciaHardware actualizar(IncidenciaHardware incidenciaHardware) {
        return hardwareRepository.save(incidenciaHardware);
    }

    public void eliminar(Integer id) {
        hardwareRepository.deleteById(id);
    }
}