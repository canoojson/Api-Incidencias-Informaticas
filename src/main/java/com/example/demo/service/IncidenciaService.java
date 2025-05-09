package com.example.demo.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Incidencia;
import com.example.demo.repository.IncidenciaRepository;


@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

        public Incidencia crearIncidencia(Incidencia incidencia) {
            if(incidencia.getFecha_incidencia()==null){
                throw new RuntimeException("No se ha definido la fecha de la incidencia.");
            }else{
                return incidenciaRepository.save(incidencia);
            }
        }

        public List<Incidencia> obtenerTodasLasIncidencias() {
            return incidenciaRepository.findAll();
        }

        public Optional<Incidencia> obtenerIncidenciaPorId(Integer id) {
            return incidenciaRepository.findById(id);
        }

        public Incidencia actualizarIncidencia(Incidencia incidencia) {
            return incidenciaRepository.save(incidencia);
        }

        public void eliminarIncidencia(Integer id) {
            incidenciaRepository.deleteById(id);
        }
    }


