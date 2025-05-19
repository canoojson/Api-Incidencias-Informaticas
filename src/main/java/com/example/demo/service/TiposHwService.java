package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.TiposHw;
import com.example.demo.repository.TipoRepository;

@Service
public class TiposHwService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	public TiposHw crearTipoHw(TiposHw tiposHw) {
		return tipoRepository.save(tiposHw);
	}
	
	public List<TiposHw> obtenerTodosLosTipoHw() {
        return tipoRepository.findAll();
    }

    public Optional<TiposHw> obtenerTipoHwPorId(Integer id) {
        return tipoRepository.findById(id);
    }

    public TiposHw actualizarTipoHw(TiposHw tiposHw) {
        return tipoRepository.save(tiposHw);
    }

    public void eliminarTipoHw(Integer id) {
    	tipoRepository.deleteById(id);
    }
}
