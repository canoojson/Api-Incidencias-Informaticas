package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estado;
import com.example.demo.repository.EstadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado crearEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> obtenerTodosLosEstados() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> obtenerEstadoPorId(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado actualizarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Integer id) {
        estadoRepository.deleteById(id);
    }
}

