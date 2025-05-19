package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public Ubicacion crearUbicacion(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public List<Ubicacion> obtenerTodasLasUbicaciones() {
        return ubicacionRepository.findAll();
    }

    public Optional<Ubicacion> obtenerUbicacionPorId(Integer id) {
        return ubicacionRepository.findById(id);
    }

    public Ubicacion actualizarUbicacion(Integer id, Ubicacion ubicacion) {
        if(ubicacionRepository.existsById(id)) {
        	System.out.println("ID:" + id.toString());
        	ubicacion.setIdUbicacion(id);
        	System.out.println("UBICACION2: " + ubicacion.getIdUbicacion().toString());
        	return ubicacionRepository.save(ubicacion);
        }
        throw new RuntimeException("Ubicacion no encontrada");
    }

    public void eliminarUbicacion(Integer id) {
    	if (ubicacionRepository.existsById(id)) {
    		ubicacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ubicacion no encontrada");
        }
    }
}

