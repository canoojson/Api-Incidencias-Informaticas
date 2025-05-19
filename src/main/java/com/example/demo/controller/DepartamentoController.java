package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departamento;
import com.example.demo.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping
	public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento departamento){
		Departamento nuevoDepartamento = departamentoService.crearDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDepartamento);
	}
	
	@GetMapping
	public List<Departamento> obtenerTodosLosDepartamentos(){
		return departamentoService.obtenerTodosLosDepartamentos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> obtenerDepartamentoPorId(@PathVariable Integer id){
		Optional<Departamento> departamento = departamentoService.obtenerDepartamentoPorId(id);
		return departamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Departamento> actualizarDepartamento(@PathVariable Integer id, @RequestBody Departamento detallesDepartamento){
		Optional<Departamento> departamentoExistente = departamentoService.obtenerDepartamentoPorId(id);
		if(departamentoExistente.isPresent()) {
			Departamento departamento = departamentoExistente.get();
			departamento.setNombreDpto(detallesDepartamento.getNombreDpto());
			Departamento departamentoActualizado = departamentoService.actualizarDepartamento(departamento);
			return ResponseEntity.ok(departamentoActualizado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarDepartamento(@PathVariable Integer id){
		Optional<Departamento> departamento = departamentoService.obtenerDepartamentoPorId(id);
		if(departamento.isPresent()) {
			departamentoService.eliminarDepartamento(id);
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
