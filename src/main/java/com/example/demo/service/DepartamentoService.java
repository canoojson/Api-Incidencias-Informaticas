package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRespository;
	
	public Departamento crearDepartamento(Departamento departamento) {
		return departamentoRespository.save(departamento);
	}
	
	public List<Departamento> obtenerTodosLosDepartamentos() {
        return departamentoRespository.findAll();
    }

    public Optional<Departamento> obtenerDepartamentoPorId(Integer id) {
        return departamentoRespository.findById(id);
    }

    public Departamento actualizarDepartamento(Departamento departamento) {
        return departamentoRespository.save(departamento);
    }

    public void eliminarDepartamento(Integer id) {
    	departamentoRespository.deleteById(id);
    }

}
